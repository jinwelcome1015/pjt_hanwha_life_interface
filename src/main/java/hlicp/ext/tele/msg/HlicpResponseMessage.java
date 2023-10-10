package hlicp.ext.tele.msg;


public class HlicpResponseMessage {

    private String msgeCode = "";
    private String msgeOtptDvsnCode = "";
    private String msgeCntn = "";

    public HlicpResponseMessage() {
    }

    public HlicpResponseMessage(String msgeCode) {
        this.msgeCode = msgeCode;
    }

    public HlicpResponseMessage(String msgeCode, String msgeOtptDvsnCode,
                                String msgeCntn) {
        this.msgeCode = msgeCode;
        this.msgeOtptDvsnCode = msgeOtptDvsnCode;
        this.msgeCntn = msgeCntn;
    }

    public String getMsgeCode() {
        return msgeCode;
    }

    public void setMsgeCode(String msgeCode) {
        this.msgeCode = msgeCode;
    }

    public String getMsgeOtptDvsnCode() {
        return msgeOtptDvsnCode;
    }

    public void setMsgeOtptDvsnCode(String msgeOtptDvsnCode) {
        this.msgeOtptDvsnCode = msgeOtptDvsnCode;
    }

    public String getMsgeCntn() {
        return msgeCntn;
    }

    public void setMsgeCntn(String msgeCntn) {
        this.msgeCntn = msgeCntn;
    }


    @Override
    public String toString() {
        return "HlicpResponseMessage [msgeCode=" + msgeCode + ", msgeOtptDvsnCode=" + msgeOtptDvsnCode + ", msgeCntn=" + msgeCntn
                + "]";
    }

}
