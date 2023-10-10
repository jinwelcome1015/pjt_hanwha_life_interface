package hlicp.ext.tele.rest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.params.HttpClientParams;

public class RestTemplateFactory {

    private static final int READ_TIMEOUT = 60000;       // 60초
    private static final int CONNECTION_TIMEOUT = 5000;  // 5초


    public static RestTemplate createRestTemplste() {
        HttpClientParams clientParams = new HttpClientParams();

        HttpClient client = new HttpClient(clientParams);
        client.setConnectionTimeout(CONNECTION_TIMEOUT);
        client.setTimeout(READ_TIMEOUT);

        return new RestTemplate(client);
    }

}
