package hlicp.ext.tele.rest;

import hlicp.ext.tele.msg.HlicpMessageHeader;
import hlicp.ext.tele.msg.SimpleMessageEnvelop;

public interface RestApiClient<P, R> {

    R sendAndReceive(HlicpMessageHeader header, P input, Class<R> output);

    SimpleMessageEnvelop<HlicpMessageHeader, R> sendAndReceiveMessage(HlicpMessageHeader header1, P input, Class<R> output);

    String sendAndReceive(String sendData);

}
