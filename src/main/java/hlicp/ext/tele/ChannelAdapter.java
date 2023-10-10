package hlicp.ext.tele;

import hlicp.ext.tele.constant.TeleConstant;
import hlicp.ext.tele.exception.TeleException;
import hlicp.ext.tele.msg.HlicpMessageHeader;
import hlicp.ext.tele.msg.HlicpResponseMessage;
import hlicp.ext.tele.msg.SimpleMessageEnvelop;
import hlicp.ext.tele.rest.DefaultRestApiClient;
import hlicp.ext.tele.utils.TeleUtils;

import java.util.List;



public class ChannelAdapter {

    /**
     * 전문 헤더 생성
     *
     * @param itfcId         시스템 인터페이스ID
     * @param rcveSrvcId     수신 서비스 ID
     * @param rcveSysCode    수신 시스템 코드
     * @return Hlicp용 표준 전문 헤더 DTO
     */
    public HlicpMessageHeader createHeader(String itfcId, String rcveSrvcId, String rcveSysCode) {
        return createHeader(itfcId, rcveSrvcId, rcveSysCode, "N");
    }


    /**
     * 전문 헤더 생성
     *
     * @param itfcId         시스템 인터페이스ID
     * @param rcveSrvcId     수신 서비스 ID
     * @param rcveSysCode    수신 시스템 코드
     * @param prsnInfoIncsYn 개인정보 포함여부
     * @return Hlicp용 표준 전문 헤더 DTO
     */
    public HlicpMessageHeader createHeader(String itfcId, String rcveSrvcId, String rcveSysCode, String prsnInfoIncsYn) {
        // 전문 헤더 객체 생성
        HlicpMessageHeader header = new HlicpMessageHeader();
        header.setItfcId(itfcId);                   // 시스템 인터페이스ID
        header.setRcveSrvcId(rcveSrvcId);           // 수신 서비스 ID
        header.setChnlTypeCode("SVR");              // SERVER 값 세팅시 코어 AP 인증체크하지 않음
        header.setTrnmSysCode(getTrnmSysCode());    // 송신 시스템 코드
        header.setRcveSysCode(rcveSysCode);         // 수신 시스템 코드
        header.setEmnb(getEmnb());                  // 사원번호
        header.setBelnOrgnCode(getBelnOrgnCode());  // 소속기관코드
        header.setPrsnInfoIncsYn(prsnInfoIncsYn);   // 개인정보포함여부(Y.포함, N.미포함)
        // header.setScrnId("ComSysOnlnOprntmeSrchM");

//        header.setIpAddr(TeleUtils.getIpAddress(request));    // Client IP 주소
        header.setIpAddr(getIpAddr());                          // Client IP 주소
        header.setTlgrCretDttm(TeleUtils.getTlgrCretDttm());    // 전문생성일시
        header.setRndmNo(TeleUtils.getRndmNo());                // 거래번호(랜덤)
        header.setServerType(getServerType());                  // 서버유형(D.개발)
        header.setRspnDvsnCode(TeleConstant.RSPN_DVSN_SEND);    // 요청응답구분 : 요청

        return header;
    }


    /**
     * 전문 전송
     *
     * @param targetType     연계 시스템 타입(MCI/ESB)
     * @param header         전문 헤더
     * @param inputDTO       input
     * @param outputDTOClass output
     * @return 응답 DTO
     */
    public <P, R> R sendAndReceive(TeleConstant.TargetType targetType, HlicpMessageHeader header, P inputDTO, Class<R> outputDTOClass) {
        //----------------------------------------------------------------------------------------------------
        // Rest API 호출을 위한 객체 생성
        //----------------------------------------------------------------------------------------------------
        String targetUrl = getTargetUrl(targetType);
        DefaultRestApiClient<P, R> client = new DefaultRestApiClient<P, R>(targetType, targetUrl);

        //----------------------------------------------------------------------------------------------------
        // 연계시스템 호출
        //----------------------------------------------------------------------------------------------------
        return client.sendAndReceive(header, inputDTO, outputDTOClass);
    }


    /**
     * 전문 전송
     *
     * @param targetType     연계 시스템 타입(MCI/ESB)
     * @param header         전문 헤더
     * @param inputDTO       input
     * @param outputDTOClass output
     * @return 응답 DTO
     */
    public <P, R> SimpleMessageEnvelop<HlicpMessageHeader, R> sendAndReceiveMessage(TeleConstant.TargetType targetType, HlicpMessageHeader header, P inputDTO, Class<R> outputDTOClass) {
        //----------------------------------------------------------------------------------------------------
        // Rest API 호출을 위한 객체 생성
        //----------------------------------------------------------------------------------------------------
        String targetUrl = getTargetUrl(targetType);
        DefaultRestApiClient<P, R> client = new DefaultRestApiClient<P, R>(targetType, targetUrl);

        //----------------------------------------------------------------------------------------------------
        // 연계시스템 호출
        //----------------------------------------------------------------------------------------------------
        SimpleMessageEnvelop<HlicpMessageHeader, R> output = client.sendAndReceiveMessage(header, inputDTO, outputDTOClass);

        //----------------------------------------------------------------------------------------------------
        // 응답결과 확인
        //----------------------------------------------------------------------------------------------------
        HlicpMessageHeader messageHeader = output.getHeader();
        if (!TeleConstant.PRCS_RSLT_DVSN_CODE_SUCCESS.equals(messageHeader.getPrcsRsltDvsnCode())) { // 성공이 아니면
            int cnt = messageHeader.getMsgeListCunt();
            List<HlicpResponseMessage> msgeList = messageHeader.getMsgeList();

            if (cnt > 0 && msgeList != null && msgeList.size() > 0) {
                throw new TeleException(msgeList.get(0).getMsgeCntn());
            }
        }

        return output;
    }


    /**
     * 송신시스템코드
     */
    private String getTrnmSysCode() {
        // TODO [시스템별구현필요] 송신 시스템 코드 환경 설정 처리
        return TeleConstant.INTERNAL_HMP;
    }


    /**
     * 서버 유형
     */
    private String getServerType() {
        // TODO [시스템별구현필요] 환경설정 처리 서버 유형 : D.개발, Q.QA, P.운영
        String serverType = "";
        String uvEnv = "";
//        String uvEnv = PropertyServiceHolder.getProperty("uv.env");
        //----------------------------------------------------------------------------------------------------
        if (TeleConstant.SERVER_TYPE_PROD.equalsIgnoreCase(uvEnv)) {
            serverType = "P";
        }
        else if (TeleConstant.SERVER_TYPE_QA.equalsIgnoreCase(uvEnv)) {
            serverType = "Q";
        }
        else {
            serverType = "D";
        }
        //----------------------------------------------------------------------------------------------------
        return serverType;
    }

    /**
     * 사원번호
     */
    private String getEmnb() {
        // TODO [시스템별구현필요] 세션 등 로그인 정보를 이용해 설정해야 한다.
//        AuthenticatedUserData userData = ContextUtil.getAuthenticatedUserData();
//        String userId = userData.getUvUserid();
//
//        return (StringUtils.isEmpty(userId)) ? "1111111" : userId;
        return "1111111";
    }

    /**
     * 소속기관코드
     */
    private String getBelnOrgnCode() {
        // TODO [시스템별구현필요] 세션 등 로그인 정보를 이용해 설정해야 한다.
//        AuthenticatedUserData userData = ContextUtil.getAuthenticatedUserData();
//        String orgCode = userData.getUvOrgcode();
//
//        return (StringUtils.isEmpty(orgCode)) ? "00477" : orgCode;
        return "00477";
    }


    /**
     * Client IP 주소
     */
    private String getIpAddr() {
//        HmpRequestInfo requestInfo = ContextUtil.getRequestInfo();
//        String ipAddr = requestInfo.getClientIp();
//        ipAddr = (StringUtils.isEmpty(ipAddr)) ? TeleUtils.getLocalServerIp() : ipAddr;
//
//        return TeleUtils.formatIP(ipAddr);
        return TeleUtils.getIpAddress(null);
    }


    /**
     * 전송대상(MCI/ESB) URL 정보
     */
    private String getTargetUrl(TeleConstant.TargetType targetType) {
        // TODO: [시스템별구현필요] 대상시스템 및 현재서버유형에 따른 URL 정보 환경설정 파일 처리


        String targetUrl = "";

        if (TeleConstant.TargetType.MCI == targetType) {
//            targetUrl = PropertyServiceHolder.getProperty("fw.hli.mci.endpoint");
//
//            if (StringUtils.isEmpty(targetUrl)) {
//                targetUrl = "http://devinf.hanwhalife.com:7711/mci";
//            }
            targetUrl = "http://devinf.hanwhalife.com:7711/mci";
        }
        else if (TeleConstant.TargetType.ESB == targetType) {
//            targetUrl = PropertyServiceHolder.getProperty("fw.hli.esb.endpoint");
//
//            if (StringUtils.isEmpty(targetUrl)) {
//                targetUrl = "http://devinf.hanwhalife.com:7711/esb";
//            }
            targetUrl = "http://devinf.hanwhalife.com:7711/esb";
        }

        return targetUrl;
    }


}
