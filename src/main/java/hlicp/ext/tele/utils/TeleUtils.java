package hlicp.ext.tele.utils;


import hlicp.ext.tele.exception.TeleException;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

public final class TeleUtils {

    private static final String DEFAULT_IP_ADDRESS = "127.0.0.1";


    public static String getIpAddress(HttpServletRequest request) {
        String result;

        if (request != null) {
            result = getClientIp(request);
        }
        else {
            result = getLocalServerIp();
        }

        return formatIP(result);
    }


    public static String getLocalServerIp() {
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();

            while (en.hasMoreElements()) {
                NetworkInterface intf = en.nextElement();
                Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses();

                while (enumIpAddr.hasMoreElements()) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()
                            && inetAddress.isSiteLocalAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        }
        catch (SocketException var4) {
//	         logger.info("[fwk] getLocalServerIp error={}", var4.getMessage());
        }

        return DEFAULT_IP_ADDRESS;
    }


    public static String getClientIp(HttpServletRequest request) {
        //----------------------------------------------------------------------------------------------------
        // Proxy나 로드밸러서의의 표준은 X-Forwarded-For 이지만 환경에 따라 다를 수 있으므로 여러 헤더를 검사한다.
        //----------------------------------------------------------------------------------------------------
        String[] httpHeaders = new String[] {
                "X-Forwarded-For",
                "Proxy-Client-IP",
                "WL-Proxy-Client-IP",
                "HTTP_CLIENT_IP",
                "HTTP_X_FORWARDED_FOR",
        };
        //----------------------------------------------------------------------------------------------------
        String ipAddr = null;
        //----------------------------------------------------------------------------------------------------
        for (String header : httpHeaders) {
            ipAddr = request.getHeader(header);
            if (ipAddr != null && !"".equals(ipAddr)) {
                break;
            }
        }
        //----------------------------------------------------------------------------------------------------
        if (ipAddr == null || "".equals(ipAddr)) {
            ipAddr = request.getRemoteAddr();
        }
        //----------------------------------------------------------------------------------------------------
        return ipAddr;
    }


    private static String formatIP(String ipAddress) {
        if (ipAddress == null || "".equals(ipAddress)) {
            return ipAddress;
        }

        StringBuilder sb = new StringBuilder();
        String[] ipList = ipAddress.split("\\.");

        for (String s : ipList) {
            sb.append(lPad(s, 3, "0"));
        }

        return sb.toString();
    }


    public static String lPad(String source, int size, String padChar) {
        StringBuilder result = new StringBuilder();

        for (int i = source.length(); i < size; i++) {
            result.append(padChar);
        }

        result.append(source);
        return result.toString();
    }


    /**
     * 전문생성일시
     */
    public static String getTlgrCretDttm() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    /**
     * 거래번호(랜덤)
     */
    public static String getRndmNo() {
        final String ALGORITHM_SHA1 = "SHA1PRNG";
        final int DEFAULT_SIZE = 4;
        final String DEFAULT_PAD_CHAR = "0";

        try {
            SecureRandom random = SecureRandom.getInstance(ALGORITHM_SHA1);
            return TeleUtils.lPad(String.valueOf(random.nextInt(10000)), DEFAULT_SIZE, DEFAULT_PAD_CHAR);
        }
        catch (NoSuchAlgorithmException e) {
            throw new TeleException(e);
        }
    }

}
