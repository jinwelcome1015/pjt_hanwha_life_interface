/**
 * Copyright 2020 All rights reserved by 한화시스템/ICT
 */
package com.hanwhalife.common.insr.core.dto;

/**
 * SSO대체로그인인증 (comItfcUserCtfnPSI001c)
 */
public class UserCtfnDTO {

    /**
     * 생성자
     */
    public UserCtfnDTO() {

    }

    /**
     * 생성자 (사번, 패스워드)
     */
    public UserCtfnDTO(String emnb, String lognPswd) {
        this.setEmnb(emnb);
        this.setLognPswd(lognPswd);
    }

    // ####################################################################################################
    // INPUT
    // ####################################################################################################

    /**
     * 사원번호
     */
    private String emnb;

    /**
     * 로그인비밀번호
     */
    private String lognPswd;

    // ####################################################################################################
    // OUTPUT
    // ####################################################################################################

    /**
     * 응답코드값
     */
    private String rspnCodeVal;

    /**
     * 응답메시지내용
     */
    private String rspnMsgeCntn;

    /**
     * 예약컬럼값
     */
    private String rsvtClmnVal;

    /**
     * 응답메시지고유ID
     */
    private String rspnMsgeUniqId;

    /**
     * 사원명
     */
    private String empeNm;

    /**
     * 주민등록번호
     */
    private String rrno;

    /**
     * 사용자구분코드
     */
    private String userDvsnCode;

    /**
     * 직책코드
     */
    private String rsofCode;

    /**
     * 직급코드
     */
    private String clpsCode;

    /**
     * 소속기관코드
     */
    private String belnOrgnCode;

    /**
     * 소속기관명
     */
    private String belnOrgnNm;

    /**
     * 영업소기관코드
     */
    private String bnofOrgnCode;

    /**
     * 영업소명
     */
    private String bnofNm;

    /**
     * 지점기관코드
     */
    private String brocOrgnCode;

    /**
     * 지점명
     */
    private String brocNm;

    /**
     * 지역단기관코드
     */
    private String lcscOrgnCode;

    /**
     * 지역단명
     */
    private String lcscNm;

    /**
     * 휴대폰번호
     */
    private String hpno;

    /**
     * 이메일주소
     */
    private String mailAddr;

    /**
     * 상위기관코드
     */
    private String hgrnOrgnCode;

    /**
     * 조직형태구분코드
     */
    private String ogztFormDvsnCode;

    /**
     * 기관전화번호
     */
    private String orgnTlno;

    /**
     * 기관축약명
     */
    private String orgnAbrvNm;

    /**
     * 상위기관명
     */
    private String hgrnOrgnNm;

    public String getEmnb() {
        return emnb;
    }

    public void setEmnb(String emnb) {
        this.emnb = emnb;
    }

    public String getLognPswd() {
        return lognPswd;
    }

    public void setLognPswd(String lognPswd) {
        this.lognPswd = lognPswd;
    }

    public String getRspnCodeVal() {
        return rspnCodeVal;
    }

    public void setRspnCodeVal(String rspnCodeVal) {
        this.rspnCodeVal = rspnCodeVal;
    }

    public String getRspnMsgeCntn() {
        return rspnMsgeCntn;
    }

    public void setRspnMsgeCntn(String rspnMsgeCntn) {
        this.rspnMsgeCntn = rspnMsgeCntn;
    }

    public String getRsvtClmnVal() {
        return rsvtClmnVal;
    }

    public void setRsvtClmnVal(String rsvtClmnVal) {
        this.rsvtClmnVal = rsvtClmnVal;
    }

    public String getRspnMsgeUniqId() {
        return rspnMsgeUniqId;
    }

    public void setRspnMsgeUniqId(String rspnMsgeUniqId) {
        this.rspnMsgeUniqId = rspnMsgeUniqId;
    }

    public String getEmpeNm() {
        return empeNm;
    }

    public void setEmpeNm(String empeNm) {
        this.empeNm = empeNm;
    }

    public String getRrno() {
        return rrno;
    }

    public void setRrno(String rrno) {
        this.rrno = rrno;
    }

    public String getUserDvsnCode() {
        return userDvsnCode;
    }

    public void setUserDvsnCode(String userDvsnCode) {
        this.userDvsnCode = userDvsnCode;
    }

    public String getRsofCode() {
        return rsofCode;
    }

    public void setRsofCode(String rsofCode) {
        this.rsofCode = rsofCode;
    }

    public String getClpsCode() {
        return clpsCode;
    }

    public void setClpsCode(String clpsCode) {
        this.clpsCode = clpsCode;
    }

    public String getBelnOrgnCode() {
        return belnOrgnCode;
    }

    public void setBelnOrgnCode(String belnOrgnCode) {
        this.belnOrgnCode = belnOrgnCode;
    }

    public String getBelnOrgnNm() {
        return belnOrgnNm;
    }

    public void setBelnOrgnNm(String belnOrgnNm) {
        this.belnOrgnNm = belnOrgnNm;
    }

    public String getBnofOrgnCode() {
        return bnofOrgnCode;
    }

    public void setBnofOrgnCode(String bnofOrgnCode) {
        this.bnofOrgnCode = bnofOrgnCode;
    }

    public String getBnofNm() {
        return bnofNm;
    }

    public void setBnofNm(String bnofNm) {
        this.bnofNm = bnofNm;
    }

    public String getBrocOrgnCode() {
        return brocOrgnCode;
    }

    public void setBrocOrgnCode(String brocOrgnCode) {
        this.brocOrgnCode = brocOrgnCode;
    }

    public String getBrocNm() {
        return brocNm;
    }

    public void setBrocNm(String brocNm) {
        this.brocNm = brocNm;
    }

    public String getLcscOrgnCode() {
        return lcscOrgnCode;
    }

    public void setLcscOrgnCode(String lcscOrgnCode) {
        this.lcscOrgnCode = lcscOrgnCode;
    }

    public String getLcscNm() {
        return lcscNm;
    }

    public void setLcscNm(String lcscNm) {
        this.lcscNm = lcscNm;
    }

    public String getHpno() {
        return hpno;
    }

    public void setHpno(String hpno) {
        this.hpno = hpno;
    }

    public String getMailAddr() {
        return mailAddr;
    }

    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
    }

    public String getHgrnOrgnCode() {
        return hgrnOrgnCode;
    }

    public void setHgrnOrgnCode(String hgrnOrgnCode) {
        this.hgrnOrgnCode = hgrnOrgnCode;
    }

    public String getOgztFormDvsnCode() {
        return ogztFormDvsnCode;
    }

    public void setOgztFormDvsnCode(String ogztFormDvsnCode) {
        this.ogztFormDvsnCode = ogztFormDvsnCode;
    }

    public String getOrgnTlno() {
        return orgnTlno;
    }

    public void setOrgnTlno(String orgnTlno) {
        this.orgnTlno = orgnTlno;
    }

    public String getOrgnAbrvNm() {
        return orgnAbrvNm;
    }

    public void setOrgnAbrvNm(String orgnAbrvNm) {
        this.orgnAbrvNm = orgnAbrvNm;
    }

    public String getHgrnOrgnNm() {
        return hgrnOrgnNm;
    }

    public void setHgrnOrgnNm(String hgrnOrgnNm) {
        this.hgrnOrgnNm = hgrnOrgnNm;
    }

    @Override
    public String toString() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("UserCtfnDTO [");
        stringBuffer.append("emnb=").append(emnb).append(", ");
        stringBuffer.append("rspnCodeVal=").append(rspnCodeVal).append(", ");
        stringBuffer.append("rspnMsgeCntn=").append(rspnMsgeCntn).append(", ");
        stringBuffer.append("rsvtClmnVal=").append(rsvtClmnVal).append(", ");
        stringBuffer.append("rspnMsgeUniqId=").append(rspnMsgeUniqId).append(", ");
        stringBuffer.append("empeNm=").append(empeNm).append(", ");
        stringBuffer.append("rrno=").append(rrno).append(", ");
        stringBuffer.append("userDvsnCode=").append(userDvsnCode).append(", ");
        stringBuffer.append("rsofCode=").append(rsofCode).append(", ");
        stringBuffer.append("clpsCode=").append(clpsCode).append(", ");
        stringBuffer.append("belnOrgnCode=").append(belnOrgnCode).append(", ");
        stringBuffer.append("belnOrgnNm=").append(belnOrgnNm).append(", ");
        stringBuffer.append("bnofOrgnCode=").append(bnofOrgnCode).append(", ");
        stringBuffer.append("bnofNm=").append(bnofNm).append(", ");
        stringBuffer.append("brocOrgnCode=").append(brocOrgnCode).append(", ");
        stringBuffer.append("brocNm=").append(brocNm).append(", ");
        stringBuffer.append("lcscOrgnCode=").append(lcscOrgnCode).append(", ");
        stringBuffer.append("lcscNm=").append(lcscNm).append(", ");
        stringBuffer.append("hpno=").append(hpno).append(", ");
        stringBuffer.append("mailAddr=").append(mailAddr).append(", ");
        stringBuffer.append("hgrnOrgnCode=").append(hgrnOrgnCode).append(", ");
        stringBuffer.append("ogztFormDvsnCode=").append(ogztFormDvsnCode).append(", ");
        stringBuffer.append("orgnTlno=").append(orgnTlno).append(", ");
        stringBuffer.append("orgnAbrvNm=").append(orgnAbrvNm);
        stringBuffer.append("]");

        return stringBuffer.toString();
    }

}