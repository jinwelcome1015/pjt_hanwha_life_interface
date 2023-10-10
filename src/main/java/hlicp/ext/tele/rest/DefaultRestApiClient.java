package hlicp.ext.tele.rest;

import com.fasterxml.jackson.databind.JavaType;
import hlicp.ext.tele.constant.TeleConstant;
import hlicp.ext.tele.exception.TeleException;
import hlicp.ext.tele.msg.HlicpMessageHeader;
import hlicp.ext.tele.msg.HlicpSimpleOnlineMessage;
import hlicp.ext.tele.msg.MessageTypeResolver;
import hlicp.ext.tele.msg.SimpleMessageEnvelop;
import hlicp.ext.tele.utils.json.JacksonObjectMapperUtils;
import hlicp.ext.tele.utils.json.JsonUtils;
import hlicp.ext.tele.utils.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DefaultRestApiClient<P, R> implements RestApiClient<P, R> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected MessageTypeResolver messageTypeResolver = null;
    private final String targetUrl;
    private final String targetType;

    public DefaultRestApiClient(TeleConstant.TargetType targetType, String targetUrl) {
        this.targetType = targetType.name();
        this.targetUrl = targetUrl;

        MessageTypeResolver messageTypeResolver = new MessageTypeResolver();
        messageTypeResolver.setHeaderType(HlicpMessageHeader.class);
        messageTypeResolver.setOutboundMessageType(HlicpSimpleOnlineMessage.class);
        this.setMessageTypeResolver(messageTypeResolver);
    }


    @Override
    public R sendAndReceive(HlicpMessageHeader header, P sendVo, Class<R> resultType) {
        SimpleMessageEnvelop<HlicpMessageHeader, R> result = sendAndReceiveMessage(header, sendVo, resultType);
        if (result != null) {
            return result.getPayload();
        }
        return null;
    }

    @Override
    public SimpleMessageEnvelop<HlicpMessageHeader, R> sendAndReceiveMessage(HlicpMessageHeader header, P sendVo, Class<R> resultType) {
        SimpleMessageEnvelop<HlicpMessageHeader, P> sendMessage = ClassUtils.createInstance(messageTypeResolver.getOutboundMessageType());
        SimpleMessageEnvelop<HlicpMessageHeader, R> result = null;

//        header.increaseNodeNumber();
        sendMessage.setHeader(header);
        sendMessage.setPayload(sendVo);

        // input logging
        logger.debug("[{} --> {} --> {}] input: {}", header.getTrnmSysCode(), targetType, header.getRcveSysCode(), sendMessage);

        String stringdataToTransfer = JsonUtils.toJson(sendMessage);
        String receivedData = sendAndReceive(stringdataToTransfer);

        if (receivedData != null) {
            JavaType type = JacksonObjectMapperUtils.getInstance().getTypeFactory()
                    .constructParametricType(messageTypeResolver.getOutboundMessageType(), resultType);
            result = JsonUtils.readValue(receivedData, type);
        }

        // output logging
        logger.debug("[{} <-- {} <-- {}] output: {}", header.getTrnmSysCode(), targetType, header.getRcveSysCode(), result);

        return result;
    }

    public String sendAndReceive(String sendString) {
        try {
            RestTemplate restTemplate = RestTemplateFactory.createRestTemplste();

            return restTemplate.postForObject(targetUrl, sendString);

        }
        catch (Throwable ex) {
            throw new TeleException(ex);
        }
    }


    public void setMessageTypeResolver(MessageTypeResolver messageTypeResolver) {
        this.messageTypeResolver = messageTypeResolver;
    }

}
