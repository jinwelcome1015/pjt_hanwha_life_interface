package hlicp.ext.tele.msg;

import java.io.Serializable;

public interface SimpleMessageEnvelop<HlicpMessageHeader, R> extends Serializable {

  HlicpMessageHeader getHeader();

   void setHeader(HlicpMessageHeader var1);

   R getPayload();

   void setPayload(R var1);
}
