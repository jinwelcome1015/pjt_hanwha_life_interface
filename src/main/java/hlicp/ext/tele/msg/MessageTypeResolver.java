package hlicp.ext.tele.msg;


import hlicp.ext.tele.utils.ClassUtils;

public class MessageTypeResolver {

    private Class<?> messageType;
    private Class<?> headerType;
    private Class<?> outboundMessageType;
    private String messageTypeName;
    private String headerTypeName;
    private String outboundMessageTypeName;

    public MessageTypeResolver() {
        if (headerType == null) {
            headerTypeName = HlicpMessageHeader.class.getName();
            headerType = ClassUtils.forName(headerTypeName);
        }
        if (outboundMessageType == null) {
            outboundMessageTypeName = HlicpSimpleOnlineMessage.class.getName();
            outboundMessageType = ClassUtils.forName(outboundMessageTypeName);
        }

    }

    public Class<?> getMessageType() {
        return messageType;
    }

    public void setMessageType(Class<?> messageType) {
        this.messageType = messageType;
    }

    public String getMessageTypeName() {
        return messageTypeName;
    }

    public void setMessageTypeName(String messageTypeName) {
        this.messageTypeName = messageTypeName;
        messageType = ClassUtils.forName(messageTypeName);
    }

    public String getHeaderTypeName() {
        return headerTypeName;
    }

    public void setHeaderTypeName(String headerTypeName) {
        this.headerTypeName = headerTypeName;
        headerType = ClassUtils.forName(headerTypeName);
    }

    public Class<?> getHeaderType() {
        return headerType;
    }

    public void setHeaderType(Class<?> headerType) {
        this.headerType = headerType;
    }

    public Class<?> getOutboundMessageType() {
        return outboundMessageType;
    }

    public void setOutboundMessageType(Class<?> outboundMessageType) {
        this.outboundMessageType = outboundMessageType;
    }

    public String getOutboundMessageTypeName() {
        return outboundMessageTypeName;
    }

    public void setOutboundMessageTypeName(String outboundMessageTypeName) {
        this.outboundMessageTypeName = outboundMessageTypeName;
        outboundMessageType = ClassUtils.forName(outboundMessageTypeName);
    }

}