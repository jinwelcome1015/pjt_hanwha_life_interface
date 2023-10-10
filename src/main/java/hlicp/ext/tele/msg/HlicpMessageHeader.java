package hlicp.ext.tele.msg;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Hlicp용 표준 전문 헤더
 */
public class HlicpMessageHeader implements Serializable {

	private static final long serialVersionUID = -4322491909373843506L;
	private String trnnNo;


	/* ----시스템 공통부----- **/

	/**
	 * 송신시스템코드 'NON' : 헤더가 파싱되기 이전에 송신시스템 코드는 null 임
	 */
	private String trnmSysCode = "";
	/**
	 * IP주소 거래번호 필드, 10.10.10.59일 경우 “010010010059”
	 */
	private String ipAddr = "";
	/**
	 * 전문생성일시 거래번호 필드, YYYYMMDD(8)+HHMMSS(6)+sss(3)(1/1000초)
	 */
	private String tlgrCretDttm = "";
	/**
	 * 임의번호 거래번호 필드, 랜덤번호, 범위=1~9999
	 */
	private String rndmNo = "";
	/**
	 * 이력번호 시스템 경유 이력 번호 / 1부터 시작 시스템 경유시 마다 +1 증가 설정
	 */
	private int hsno = 1;
	/** 인증토큰 */
	private String ctfnTokn = "";
	/**
	 * 원거래 거래번호 보상 거래일 경우 원거래 거래번호를 설정 (송신 시스템 코드+IP주소+전문생성일시+임의번호)
	 */
	private String ogtsrndmNo = "";
	/**
	 * 개인 정보 포함 여부 “Y”=개인정보 포함데이터, “N”=개인정보 포함데이터 아님
	 */
	private String prsnInfoIncsYn = "";
	/**
	 * 인터페이스 ID 전문관리시스템에서 부여된 인터페이스ID
	 */
	private String itfcId = "";
	/** 수신 서비스 아이디 */
	private String rcveSrvcId = "";
	/** 수신 시스템 코드 */
	private String rcveSysCode = "";
	/**
	 * MCI노드번호 MCI에서 송신시 노드 정보 설정 ( IGATE + MCI노드ID(1) + MCI서버ID(1) )
	 */
	private String mciNodeNo = "";
	/**
	 * MCI세션ID 통합UI에서 MCI 로그인 업무시 발급받은 세션ID를 셋팅
	 */
	private String mciSesnId = "";
	/** 서버 유형 */
	private String serverType = "";
	/**
	 * 요청응답구분 “S”=요청(Send), “R”=응답(Receive), “1”=요청에 대한 더미응답, “2”=응답에 대한 더미응답
	 */
	private String rspnDvsnCode = "";


	/* ----요청정보-------- */

	/** 사원번호(로그인사번) */
	private String emnb = "";
	/** 소속기관코드 */
	private String belnOrgnCode = "";
	/** 고객ID */
	private String custId = "";
	/**
	 * 채널유형 “UI”=PC, “SVR”=SERVER, 기본값=“”
	 */
	private String chnlTypeCode = "";
	/** 거래발생화면ID */
	private String scrnId = "";
	/** 거래발생이전화면ID */
	private String befoScrnId = "";

	/**
	 * 사용자 단말기 식별값
	 */
	private String userTmunIdnfVal = "";
	/**
	 * 요청자IP 10.10.10.59일 경우 “10.10.10.59”
	 */
	private String rqsrIP = "";
	/**
	 * 최초송신시간 YYYYMMDD(8)+HHMMSS(6)+sss(3)(1/1000초), 기본값=“”
	 */
	private String rqstDttm = "";
	/**
	 * 조회 건수
	 */
	private int totalCount = 0;
	/** 마지막 페이지 여부 */
	private String lastPageYn = "";
	/**
	 * 기본 통화 달러=USD, 원=KOR, 엔화=JPY 등등, ISO-4217규격 참조, 기본값=“”
	 */
	private String baseCrny = "";
	/**
	 * 국가정보 미국=USA, 대한민국=KOR 등등, ISO-3166-1규격 참조, 기본값=“”
	 */
	private String baseCnty = "";
	/**
	 * 사용언어 한국어=kor,일본어=jpn등등, ISO-639-2규격 참조, 기본값=“”, 2자리이면 ISO-639-1규격 참조
	 */
	private String baseLang = "";


	/* -----응답정보----- */

	/**
	 * 전문응답일시 YYYYMMDD(8)+HHMMSS(6)+sss(3)(1/1000초)
	 */
	private String tlgrRspnDttm = "";
	/**
	 * 처리결과구분코드 1=정상, 0=비정상, 9=대기(동기거래비동기응답대기)
	 */
	private String prcsRsltDvsnCode = "";


	/* -----메시지----------- */

	/**
	 * 메시지 목록 건수 메시지 반복 건수 만큼 메시지코드,메시지내용,출력방법 데이터 반복, 기본값 = 1
	 */
	private int msgeListCunt = 1;
	/**
	 * 메시지 목록
	 */
	private List<HlicpResponseMessage> msgeList = new ArrayList<HlicpResponseMessage>(1);
	/**
	 * 에러내용 개발모드에서 임시로 모든 에러정보 표시
	 */
	private String msgeStackTrace = "";


	/* ----- 시스템 에러시 처리을 위한 필드 ----- */
	/**
	 * 응답코드
	 */
	@JsonIgnore
	private String responseCode;
	/**
	 * 응답메시지
	 */
	@JsonIgnore
	private String responseMsg;
	/**
	 *  client id
	 */
	@JsonIgnore
	private String clientId = "";


	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseMessage(String message) {
		responseMsg = message;
	}

	public void setAdditionalMessage(String rootCauseMessage) {
		msgeStackTrace = rootCauseMessage;
	}

	public String getScreenId() {
		return scrnId;
	}

	public String getServiceId() {
		return rcveSrvcId;
	}

	public void setServiceId(String serviceId) {
		rcveSrvcId = serviceId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getGlobalNo() {
		if (trnnNo == null) {
			trnnNo = (trnmSysCode + ipAddr + tlgrCretDttm + rndmNo);
		}
		return trnnNo;
	}

	public void setGlobalNo(String trnnNo) {
		this.trnnNo = trnnNo;
		trnmSysCode = trnnNo.substring(0, 3);
		ipAddr = trnnNo.substring(3, 15);
		tlgrCretDttm = trnnNo.substring(15, 32);
		rndmNo = trnnNo.substring(32, 36);
	}

	public void setRequestOrResponse(String reqOrRes) {
		rspnDvsnCode = reqOrRes;
	}

	public void setResponseResult(String result) {
		prcsRsltDvsnCode = result;
	}

	public void setResponseTimestamp(String timestamp) {
		tlgrRspnDttm = timestamp;
	}

	public String getTrnnNo() {
		return getGlobalNo();
	}

	public void setTrnnNo(String trnnNo) {
		setGlobalNo(trnnNo);
	}

	public int getHsno() {
		return hsno;
	}

	public void setHsno(int hsno) {
		this.hsno = hsno;
	}

	public String getCtfnTokn() {
		return ctfnTokn;
	}

	public void setCtfnTokn(String ctfnTokn) {
		this.ctfnTokn = ctfnTokn;
	}

	public String getRspnDvsnCode() {
		return rspnDvsnCode;
	}

	public void setRspnDvsnCode(String rspnDvsnCode) {
		this.rspnDvsnCode = rspnDvsnCode;
	}

	public String getChnlTypeCode() {
		return chnlTypeCode;
	}

	public void setChnlTypeCode(String chnlTypeCode) {
		this.chnlTypeCode = chnlTypeCode;
	}

	public String getTlgrRspnDttm() {
		return tlgrRspnDttm;
	}

	public void setTlgrRspnDttm(String tlgrRspnDttm) {
		this.tlgrRspnDttm = tlgrRspnDttm;
	}

	public String getPrcsRsltDvsnCode() {
		return prcsRsltDvsnCode;
	}

	public void setPrcsRsltDvsnCode(String prcsRsltDvsnCode) {
		this.prcsRsltDvsnCode = prcsRsltDvsnCode;
	}

	public String getOgtsrndmNo() {
		return ogtsrndmNo;
	}

	public void setOgtsrndmNo(String ogtsrndmNo) {
		this.ogtsrndmNo = ogtsrndmNo;
	}

	public String getItfcId() {
		return itfcId;
	}

	public void setItfcId(String itfcId) {
		this.itfcId = itfcId;
	}

	public String getScrnId() {
		return scrnId;
	}

	public void setScrnId(String scrnId) {
		this.scrnId = scrnId;
	}

	public String getBefoScrnId() {
		return befoScrnId;
	}

	public void setBefoScrnId(String befoScrnId) {
		this.befoScrnId = befoScrnId;
	}

	public String getClientId() {
		return clientId;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getLastPageYn() {
		return lastPageYn;
	}

	public void setLastPageYn(String lastPageYn) {
		this.lastPageYn = lastPageYn;
	}

	public String getRqsrIP() {
		return rqsrIP;
	}

	public void setRqsrIP(String rqsrIP) {
		this.rqsrIP = rqsrIP;
	}

	public String getRqstDttm() {
		return rqstDttm;
	}

	public void setRqstDttm(String rqstDttm) {
		this.rqstDttm = rqstDttm;
	}

	public String getBaseCrny() {
		return baseCrny;
	}

	public void setBaseCrny(String baseCrny) {
		this.baseCrny = baseCrny;
	}

	public String getBaseCnty() {
		return baseCnty;
	}

	public void setBaseCnty(String baseCnty) {
		this.baseCnty = baseCnty;
	}

	public String getBaseLang() {
		return baseLang;
	}

	public void setBaseLang(String baseLang) {
		this.baseLang = baseLang;
	}

	public String getMsgeStackTrace() {
		return msgeStackTrace;
	}

	public void setMsgeStackTrace(String msgeStackTrace) {
		this.msgeStackTrace = msgeStackTrace;
	}

	public String getEmnb() {
		return emnb;
	}

	public void setEmnb(String emnb) {
		this.emnb = emnb;
	}

	public String getBelnOrgnCode() {
		return belnOrgnCode;
	}

	public void setBelnOrgnCode(String belnOrgnCode) {
		this.belnOrgnCode = belnOrgnCode;
	}

	public String getCustId() {
		return custId;
	}

	public String getTrnmSysCode() {
		return trnmSysCode;
	}

	public void setTrnmSysCode(String trnmSysCode) {
		this.trnmSysCode = trnmSysCode;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getTlgrCretDttm() {
		return tlgrCretDttm;
	}

	public void setTlgrCretDttm(String tlgrCretDttm) {
		this.tlgrCretDttm = tlgrCretDttm;
	}

	public String getRndmNo() {
		return rndmNo;
	}

	public void setRndmNo(String rndmNo) {
		this.rndmNo = rndmNo;
	}

	public String getPrsnInfoIncsYn() {
		return prsnInfoIncsYn;
	}

	public void setPrsnInfoIncsYn(String prsnInfoIncsYn) {
		this.prsnInfoIncsYn = prsnInfoIncsYn;
	}

	public String getRcveSrvcId() {
		return rcveSrvcId;
	}

	public void setRcveSrvcId(String rcveSrvcId) {
		this.rcveSrvcId = rcveSrvcId;
	}

	public String getRcveSysCode() {
		return rcveSysCode;
	}

	public void setRcveSysCode(String rcveSysCode) {
		this.rcveSysCode = rcveSysCode;
	}

	public String getMciNodeNo() {
		return mciNodeNo;
	}

	public void setMciNodeNo(String mciNodeNo) {
		this.mciNodeNo = mciNodeNo;
	}

	public String getMciSesnId() {
		return mciSesnId;
	}

	public void setMciSesnId(String mciSesnId) {
		this.mciSesnId = mciSesnId;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public List<HlicpResponseMessage> getMsgeList() {
		return msgeList;
	}

	public void setMsgeList(List<HlicpResponseMessage> msgeList) {
		this.msgeList = msgeList;
	}

	public int getMsgeListCunt() {
		return msgeListCunt;
	}

	public void setMsgeListCunt(int msgeListCunt) {
		this.msgeListCunt = msgeListCunt;
	}

	public void increaseNodeNumber() {
		hsno += 1;
	}

	public void addMsgeList(HlicpResponseMessage responseMessage) {
		msgeList.add(responseMessage);
	}

	public void afterPropertiesSet() {
		if (msgeList.isEmpty()) {
			msgeList.add(new HlicpResponseMessage(responseCode, "2", responseMsg));
		}
	}

	public String getServerType() {
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	public String getUserTmunIdnfVal() {
		return userTmunIdnfVal;
	}

	public void setUserTmunIdnfVal(String userTmunIdnfVal) {
		this.userTmunIdnfVal = userTmunIdnfVal;
	}

	@Override
	public String toString() {
		return "HlicpMessageHeader [trnnNo=" + trnnNo + ", trnmSysCode=" + trnmSysCode + ", ipAddr=" + ipAddr
				+ ", tlgrCretDttm=" + tlgrCretDttm + ", rndmNo=" + rndmNo + ", hsno=" + hsno + ", ctfnTokn=" + ctfnTokn
				+ ", ogtsrndmNo=" + ogtsrndmNo + ", prsnInfoIncsYn=" + prsnInfoIncsYn + ", itfcId=" + itfcId
				+ ", rcveSrvcId=" + rcveSrvcId + ", rcveSysCode=" + rcveSysCode + ", mciNodeNo=" + mciNodeNo
				+ ", mciSesnId=" + mciSesnId + ", serverType=" + serverType + ", rspnDvsnCode=" + rspnDvsnCode
				+ ", emnb=" + emnb + ", belnOrgnCode=" + belnOrgnCode + ", custId=" + custId + ", chnlTypeCode="
				+ chnlTypeCode + ", scrnId=" + scrnId + ", befoScrnId=" + befoScrnId + ", userTmunIdnfVal="
				+ userTmunIdnfVal + ", rqsrIP=" + rqsrIP + ", rqstDttm=" + rqstDttm + ", totalCount=" + totalCount
				+ ", lastPageYn=" + lastPageYn + ", baseCrny=" + baseCrny + ", baseCnty=" + baseCnty + ", baseLang="
				+ baseLang + ", tlgrRspnDttm=" + tlgrRspnDttm + ", prcsRsltDvsnCode=" + prcsRsltDvsnCode
				+ ", msgeListCunt=" + msgeListCunt + ", msgeList=" + msgeList + ", msgeStackTrace=" + msgeStackTrace
				+ ", responseCode=" + responseCode + ", responseMsg=" + responseMsg + ", clientId=" + clientId + "]";
	}


}