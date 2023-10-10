package com.hanwhalife.common.insr.core;

import java.util.List;

import hlicp.ext.tele.constant.TeleConstant;
import hlicp.ext.tele.exception.TeleException;
import hlicp.ext.tele.msg.HlicpMessageHeader;
import hlicp.ext.tele.msg.HlicpResponseMessage;
import hlicp.ext.tele.msg.SimpleMessageEnvelop;
import hlicp.ext.tele.rest.DefaultRestApiClient;
import hlicp.ext.tele.utils.TeleUtils;

public class ChannelAdapter {

    private final String trnmSysCode = TeleConstant.INTERNAL_HIP; // 송신시스템코드

    private final String emnb = "2210037"; // 사번

    private final String belnOrgnCode = "00025"; // 소속기관코드

    private String activeProfile; // 활성 프로필(PROD, QA, DEV, LOCAL)

    private String targetUrl; // 전송대상(MCI/ESB/FEP) URL 정보

    /**
     * 생성자
     */
    public ChannelAdapter() {

    }

    /**
     * 생성자 (사번, 소속기관코드)
     */
    public ChannelAdapter(String activeProfile, String targetUrl) {
        this.setActiveProfile(activeProfile);
        this.setTargetUrl(targetUrl);
    }

    /**
     * 전문 헤더 생성
     *
     * @param itfcId      시스템 인터페이스ID
     * @param rcveSrvcId  수신 서비스 ID
     * @param rcveSysCode 수신 시스템 코드
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
        header.setItfcId(itfcId); // 시스템 인터페이스ID
        header.setRcveSrvcId(rcveSrvcId); // 수신 서비스 ID
        header.setChnlTypeCode("SVR"); // SERVER 값 세팅시 코어 AP 인증체크하지 않음
        header.setTrnmSysCode(this.getTrnmSysCode()); // 송신 시스템 코드
        header.setRcveSysCode(rcveSysCode); // 수신 시스템 코드
        header.setEmnb(this.getEmnb()); // 사원번호
        header.setBelnOrgnCode(this.getBelnOrgnCode()); // 소속기관코드
        header.setPrsnInfoIncsYn(prsnInfoIncsYn); // 개인정보포함여부(Y.포함, N.미포함)
        // header.setScrnId("ComSysOnlnOprntmeSrchM");

        // header.setIpAddr(TeleUtils.getIpAddress(request)); // Client IP 주소
        header.setIpAddr(this.getIpAddr()); // Client IP 주소
        header.setTlgrCretDttm(TeleUtils.getTlgrCretDttm()); // 전문생성일시
        header.setRndmNo(TeleUtils.getRndmNo()); // 거래번호(랜덤)
        header.setServerType(this.getServerType()); // 서버유형(D.개발)
        header.setRspnDvsnCode(TeleConstant.RSPN_DVSN_SEND); // 요청응답구분 : 요청

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
        // ----------------------------------------------------------------------------------------------------
        // Rest API 호출을 위한 객체 생성
        // ----------------------------------------------------------------------------------------------------
        String targetUrl = getTargetUrl(targetType);
        DefaultRestApiClient<P, R> client = new DefaultRestApiClient<P, R>(targetType, targetUrl);

        // ----------------------------------------------------------------------------------------------------
        // 연계시스템 호출
        // ----------------------------------------------------------------------------------------------------
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
    public <P, R> SimpleMessageEnvelop<HlicpMessageHeader, R> sendAndReceiveMessage(TeleConstant.TargetType targetType, HlicpMessageHeader header, P inputDTO,
            Class<R> outputDTOClass) {
        // ----------------------------------------------------------------------------------------------------
        // Rest API 호출을 위한 객체 생성
        // ----------------------------------------------------------------------------------------------------
        String targetUrl = getTargetUrl(targetType);
        DefaultRestApiClient<P, R> client = new DefaultRestApiClient<P, R>(targetType, targetUrl);

        // ----------------------------------------------------------------------------------------------------
        // 연계시스템 호출
        // ----------------------------------------------------------------------------------------------------
        SimpleMessageEnvelop<HlicpMessageHeader, R> output = client.sendAndReceiveMessage(header, inputDTO, outputDTOClass);

        // ----------------------------------------------------------------------------------------------------
        // 응답결과 확인
        // ----------------------------------------------------------------------------------------------------
        HlicpMessageHeader messageHeader = output.getHeader();
        if (!TeleConstant.PRCS_RSLT_DVSN_CODE_SUCCESS.equals(messageHeader.getPrcsRsltDvsnCode())) { // 성공이 아니면
            int cnt = messageHeader.getMsgeListCunt();
            List<HlicpResponseMessage> msgeList = messageHeader.getMsgeList();

            if (cnt > 0 && msgeList != null && msgeList.size() > 0) {
                System.out.println(msgeList.get(0).getMsgeCntn());
                throw new TeleException(msgeList.get(0).getMsgeCntn());
            }
        }

        return output;
    }

    /**
     * 서버 유형
     */
    private String getServerType() {

        String profile = this.getActiveProfile();
        String uvEnv = TeleConstant.SERVER_TYPE_PROD;

        if ("local".equalsIgnoreCase(profile)) {
            uvEnv = TeleConstant.SERVER_TYPE_LOCAL;
        } else if ("dev".equalsIgnoreCase(profile)) {
            uvEnv = TeleConstant.SERVER_TYPE_DEV;
        } else if ("qa".equalsIgnoreCase(profile)) {
            uvEnv = TeleConstant.SERVER_TYPE_QA;
        }

        String serverType = "";

        if (TeleConstant.SERVER_TYPE_PROD.equalsIgnoreCase(uvEnv)) {
            serverType = "P";
        } else if (TeleConstant.SERVER_TYPE_QA.equalsIgnoreCase(uvEnv)) {
            serverType = "Q";
        } else {
            serverType = "D";
        }

        return serverType;
    }

    /**
     * Client IP 주소
     */
    private String getIpAddr() {
        // HmpRequestInfo requestInfo = ContextUtil.getRequestInfo();
        // String ipAddr = requestInfo.getClientIp();
        // ipAddr = (StringUtils.isEmpty(ipAddr)) ? TeleUtils.getLocalServerIp() : ipAddr;
        //
        // return TeleUtils.formatIP(ipAddr);
        return TeleUtils.getIpAddress(null);
    }

    /**
     * 전송대상(MCI/ESB) URL 정보
     */
    private String getTargetUrl(TeleConstant.TargetType targetType) {

        String targetUrl = this.getTargetUrl();

        if (TeleConstant.TargetType.MCI == targetType) {
            targetUrl += "/mci/" + this.getTrnmSysCode().toLowerCase();

        } else if (TeleConstant.TargetType.ESB == targetType) {
            targetUrl += "/esb";

        } else if (TeleConstant.TargetType.FEP == targetType) {
            targetUrl += "/fep";

        }

        return targetUrl;
    }

    public String getEmnb() {
        return emnb;
    }

    public String getBelnOrgnCode() {
        return belnOrgnCode;
    }

    public String getActiveProfile() {
        return activeProfile;
    }

    public void setActiveProfile(String activeProfile) {
        this.activeProfile = activeProfile;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getTrnmSysCode() {
        return trnmSysCode;
    }

}
