package hlicp.ext.tele.rest;

import hlicp.ext.tele.exception.TeleException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;


public class RestTemplate {

    private final HttpClient client;

    public static final String CONTENT_TYPE = "application/json";
    public static final String CHARSET = "UTF-8";


    public RestTemplate(HttpClient client) {
        this.client = client;
    }


    public String postForObject(String targetUrl, String sendString) {
        try {
            StringRequestEntity requestEntity = new StringRequestEntity(sendString, CONTENT_TYPE, CHARSET);
            PostMethod postMethod = new PostMethod(targetUrl);
            postMethod.setRequestEntity(requestEntity);

            int statusCode = client.executeMethod(postMethod);

            if (statusCode != HttpStatus.SC_OK) {
                String msg = null;
                switch (statusCode) {
                    case HttpStatus.SC_NOT_FOUND:
                        msg = "호출하는 페이지가 없습니다.(404)";
                        break;
                    case HttpStatus.SC_INTERNAL_SERVER_ERROR:
                        msg = "서비스 실행 중 오류가 발생하였습니다.(500)";
                        break;
                    case HttpStatus.SC_SERVICE_UNAVAILABLE:
                        msg = "서비스 실행 중 오류가 발생하였습니다.(503)";
                        break;
                }
                throw new TeleException(msg);
            }
            else {
                return postMethod.getResponseBodyAsString();
            }
        }
        catch (Exception e) {
            throw new TeleException("인터페이스 호출 오류", e);
        }
    }

}
