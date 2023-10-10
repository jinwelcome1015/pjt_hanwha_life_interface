/**
 * COPYRIGHT ⓒ Hanwha Life Insurance  CO. LTD. All rights reserved.
 * 한화생명의 사전 승인 없이 본 내용의 전부 또는 일부에 대한 복사,배포,사용을 금합니다.
 */

package hlicp.sample.dto;

import java.util.List;

/**
 * 통합코드상세조회리턴DTO
 * 
 * <pre>
 * 통합코드상세조회리턴DTO
 * </pre>
 * 
 * @author 홍길동
 * @version 1.0
 * @since 2020.04.16 init
 * @modelClassKorName 통합코드상세조회리턴DTO
 * @modelPackageKorName 02.프로세스서비스컴포넌트::01.기준정보::01.통합코드::01.통합코드검색PSI::DTO
 * @modelGenerated NOT
 */
public class IntgCodeDetlInqyReturnDTO {

	/**
	 * 통합코드ID
	 * 
	 * @modelGenerated
	 */
	private String intgCodeId;

	/**
	 * 통합코드명
	 * 
	 * @modelGenerated
	 */
	private String intgCodeNm;

	/**
	 * 데이터주제영역1레벨코드
	 * 
	 * @modelGenerated
	 */
	private String datSbjtAreaLvl1Code;

	/**
	 * 데이터주제영역2레벨코드
	 * 
	 * @modelGenerated
	 */
	private String datSbjtAreaLvl2Code;

	/**
	 * 연관기능구분코드
	 * 
	 * @modelGenerated
	 */
	private String rltoFtreDvsnCode;

	/**
	 * 연관통합코드ID1
	 * 
	 * @modelGenerated
	 */
	private String rltoIntgCodeId1;

	/**
	 * 연관통합코드ID2
	 * 
	 * @modelGenerated
	 */
	private String rltoIntgCodeId2;

	/**
	 * 설명내용
	 * 
	 * @modelGenerated
	 */
	private String istcCntn;

	/**
	 * 통합코드유효값DTO
	 * 
	 * @modelGenerated
	 */
	private List<IntgCodeValdValDTO> intgCodeValdValList;

	/**
	 * 통합코드부분적용DTO
	 * 
	 * @modelGenerated
	 */
	private List<IntgCodePrtlAplyDTO> intgCodePrtlAplyList;

	/**
	 * 통합코드ID Get Method
	 * 
	 * @modelGenerated
	 */
	public String getIntgCodeId() {
		return this.intgCodeId;
	}

	/**
	 * 통합코드ID Set Method
	 * 
	 * @modelGenerated
	 */
	public void setIntgCodeId(String intgCodeId) {
		this.intgCodeId = intgCodeId;
	}

	/**
	 * 통합코드명 Get Method
	 * 
	 * @modelGenerated
	 */
	public String getIntgCodeNm() {
		return this.intgCodeNm;
	}

	/**
	 * 통합코드명 Set Method
	 * 
	 * @modelGenerated
	 */
	public void setIntgCodeNm(String intgCodeNm) {
		this.intgCodeNm = intgCodeNm;
	}

	/**
	 * 데이터주제영역1레벨코드 Get Method
	 * 
	 * @modelGenerated
	 */
	public String getDatSbjtAreaLvl1Code() {
		return this.datSbjtAreaLvl1Code;
	}

	/**
	 * 데이터주제영역1레벨코드 Set Method
	 * 
	 * @modelGenerated
	 */
	public void setDatSbjtAreaLvl1Code(String datSbjtAreaLvl1Code) {
		this.datSbjtAreaLvl1Code = datSbjtAreaLvl1Code;
	}

	/**
	 * 데이터주제영역2레벨코드 Get Method
	 * 
	 * @modelGenerated
	 */
	public String getDatSbjtAreaLvl2Code() {
		return this.datSbjtAreaLvl2Code;
	}

	/**
	 * 데이터주제영역2레벨코드 Set Method
	 * 
	 * @modelGenerated
	 */
	public void setDatSbjtAreaLvl2Code(String datSbjtAreaLvl2Code) {
		this.datSbjtAreaLvl2Code = datSbjtAreaLvl2Code;
	}

	/**
	 * 연관기능구분코드 Get Method
	 * 
	 * @modelGenerated
	 */
	public String getRltoFtreDvsnCode() {
		return this.rltoFtreDvsnCode;
	}

	/**
	 * 연관기능구분코드 Set Method
	 * 
	 * @modelGenerated
	 */
	public void setRltoFtreDvsnCode(String rltoFtreDvsnCode) {
		this.rltoFtreDvsnCode = rltoFtreDvsnCode;
	}

	/**
	 * 연관통합코드ID1 Get Method
	 * 
	 * @modelGenerated
	 */
	public String getRltoIntgCodeId1() {
		return this.rltoIntgCodeId1;
	}

	/**
	 * 연관통합코드ID1 Set Method
	 * 
	 * @modelGenerated
	 */
	public void setRltoIntgCodeId1(String rltoIntgCodeId1) {
		this.rltoIntgCodeId1 = rltoIntgCodeId1;
	}

	/**
	 * 연관통합코드ID2 Get Method
	 * 
	 * @modelGenerated
	 */
	public String getRltoIntgCodeId2() {
		return this.rltoIntgCodeId2;
	}

	/**
	 * 연관통합코드ID2 Set Method
	 * 
	 * @modelGenerated
	 */
	public void setRltoIntgCodeId2(String rltoIntgCodeId2) {
		this.rltoIntgCodeId2 = rltoIntgCodeId2;
	}

	/**
	 * 설명내용 Get Method
	 * 
	 * @modelGenerated
	 */
	public String getIstcCntn() {
		return this.istcCntn;
	}

	/**
	 * 설명내용 Set Method
	 * 
	 * @modelGenerated
	 */
	public void setIstcCntn(String istcCntn) {
		this.istcCntn = istcCntn;
	}

	/**
	 * 통합코드유효값DTO Get Method
	 * 
	 * @modelGenerated
	 */
	public List<IntgCodeValdValDTO> getIntgCodeValdValList() {
		return this.intgCodeValdValList;
	}

	/**
	 * 통합코드유효값DTO Set Method
	 * 
	 * @modelGenerated
	 */
	public void setIntgCodeValdValList(List<IntgCodeValdValDTO> intgCodeValdValList) {
		this.intgCodeValdValList = intgCodeValdValList;
	}

	/**
	 * 통합코드부분적용DTO Get Method
	 * 
	 * @modelGenerated
	 */
	public List<IntgCodePrtlAplyDTO> getIntgCodePrtlAplyList() {
		return this.intgCodePrtlAplyList;
	}

	/**
	 * 통합코드부분적용DTO Set Method
	 * 
	 * @modelGenerated
	 */
	public void setIntgCodePrtlAplyList(List<IntgCodePrtlAplyDTO> intgCodePrtlAplyList) {
		this.intgCodePrtlAplyList = intgCodePrtlAplyList;
	}

	@Override
	public String toString() {
		return "IntgCodeDetlInqyReturnDTO [intgCodeId=" + intgCodeId + ", intgCodeNm=" + intgCodeNm
				+ ", datSbjtAreaLvl1Code=" + datSbjtAreaLvl1Code + ", datSbjtAreaLvl2Code=" + datSbjtAreaLvl2Code
				+ ", rltoFtreDvsnCode=" + rltoFtreDvsnCode + ", rltoIntgCodeId1=" + rltoIntgCodeId1
				+ ", rltoIntgCodeId2=" + rltoIntgCodeId2 + ", istcCntn=" + istcCntn + ", intgCodeValdValList="
				+ intgCodeValdValList + ", intgCodePrtlAplyList=" + intgCodePrtlAplyList + "]";
	}

}
