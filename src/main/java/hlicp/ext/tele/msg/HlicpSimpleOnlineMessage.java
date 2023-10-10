package hlicp.ext.tele.msg;

public class HlicpSimpleOnlineMessage<P> implements SimpleMessageEnvelop<HlicpMessageHeader, P> {

	private static final long serialVersionUID = 4368367582145733478L;
	private HlicpMessageHeader header;
	private P payload;


	public HlicpSimpleOnlineMessage() {
	}

	public HlicpSimpleOnlineMessage(HlicpMessageHeader header, P payload) {
		this.header = header;
		this.payload = payload;
	}

	public HlicpMessageHeader getHeader() {
		return header;
	}

	public P getPayload() {
		return payload;
	}

	public void setHeader(HlicpMessageHeader header) {
		this.header = header;
	}

	public void setPayload(P payload) {
		this.payload = payload;
	}

	public String toString() {
		return "HlicpSimpleOnlineMessage [header=" + header + ", payload=" + payload + "]";
	}
}