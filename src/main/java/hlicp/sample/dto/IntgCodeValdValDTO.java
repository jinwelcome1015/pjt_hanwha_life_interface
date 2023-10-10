/**
 * COPYRIGHT ⓒ Hanwha Life Insurance  CO. LTD. All rights reserved.
 * 한화생명의 사전 승인 없이 본 내용의 전부 또는 일부에 대한 복사,배포,사용을 금합니다.
 */

package hlicp.sample.dto;

import java.sql.Date;

/**
 * 통합코드유효값DTO
 * <pre>
 * 통합코드유효값DTO
 * </pre>
 * @author 홍길동
 * @version 1.0
 * @since 2020.04.16 init
 * @modelClassKorName 통합코드유효값DTO
 * @modelPackageKorName 02.프로세스서비스컴포넌트::01.기준정보::01.통합코드::01.통합코드검색PSI::DTO
 * @modelGenerated NOT
 */
public class IntgCodeValdValDTO {

	/**
	 * 통합코드ID
	 * @modelGenerated
	 */
	private String intgCodeId;

	/**
	 * 통합코드값
	 * @modelGenerated
	 */
	private String intgCodeVal;

	/**
	 * 통합코드값명
	 * @modelGenerated
	 */
	private String intgCodeValNm;

	/**
	 * 연관통합코드값1
	 * @modelGenerated
	 */
	private String rltoIntgCodeVal1;

	/**
	 * 연관통합코드값2
	 * @modelGenerated
	 */
	private String rltoIntgCodeVal2;

	/**
	 * 시작일자
	 * @modelGenerated
	 */
	private Date starDate;

	/**
	 * 종료일자
	 * @modelGenerated
	 */
	private Date endDate;

	/**
	 * 출력순서
	 * @modelGenerated
	 */
	private int otptOrdr;

	/**
	 * 설명내용
	 * @modelGenerated
	 */
	private String istcCntn;

	/**
	 * 통합코드ID Get Method
	 * @modelGenerated
	 */
	public String getIntgCodeId() {
		return this.intgCodeId;
	}

	/**
	 * 통합코드ID Set Method
	 * @modelGenerated
	 */
	public void setIntgCodeId(String intgCodeId) {
		this.intgCodeId = intgCodeId;
	}

	/**
	 * 통합코드값 Get Method
	 * @modelGenerated
	 */
	public String getIntgCodeVal() {
		return this.intgCodeVal;
	}

	/**
	 * 통합코드값 Set Method
	 * @modelGenerated
	 */
	public void setIntgCodeVal(String intgCodeVal) {
		this.intgCodeVal = intgCodeVal;
	}

	/**
	 * 통합코드값명 Get Method
	 * @modelGenerated
	 */
	public String getIntgCodeValNm() {
		return this.intgCodeValNm;
	}

	/**
	 * 통합코드값명 Set Method
	 * @modelGenerated
	 */
	public void setIntgCodeValNm(String intgCodeValNm) {
		this.intgCodeValNm = intgCodeValNm;
	}

	/**
	 * 연관통합코드값1 Get Method
	 * @modelGenerated
	 */
	public String getRltoIntgCodeVal1() {
		return this.rltoIntgCodeVal1;
	}

	/**
	 * 연관통합코드값1 Set Method
	 * @modelGenerated
	 */
	public void setRltoIntgCodeVal1(String rltoIntgCodeVal1) {
		this.rltoIntgCodeVal1 = rltoIntgCodeVal1;
	}

	/**
	 * 연관통합코드값2 Get Method
	 * @modelGenerated
	 */
	public String getRltoIntgCodeVal2() {
		return this.rltoIntgCodeVal2;
	}

	/**
	 * 연관통합코드값2 Set Method
	 * @modelGenerated
	 */
	public void setRltoIntgCodeVal2(String rltoIntgCodeVal2) {
		this.rltoIntgCodeVal2 = rltoIntgCodeVal2;
	}

	/**
	 * 시작일자 Get Method
	 * @modelGenerated
	 */
	public Date getStarDate() {
		return this.starDate;
	}

	/**
	 * 시작일자 Set Method
	 * @modelGenerated
	 */
	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}

	/**
	 * 종료일자 Get Method
	 * @modelGenerated
	 */
	public Date getEndDate() {
		return this.endDate;
	}

	/**
	 * 종료일자 Set Method
	 * @modelGenerated
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 출력순서 Get Method
	 * @modelGenerated
	 */
	public int getOtptOrdr() {
		return this.otptOrdr;
	}

	/**
	 * 출력순서 Set Method
	 * @modelGenerated
	 */
	public void setOtptOrdr(int otptOrdr) {
		this.otptOrdr = otptOrdr;
	}

	/**
	 * 설명내용 Get Method
	 * @modelGenerated
	 */
	public String getIstcCntn() {
		return this.istcCntn;
	}

	/**
	 * 설명내용 Set Method
	 * @modelGenerated
	 */
	public void setIstcCntn(String istcCntn) {
		this.istcCntn = istcCntn;
	}

  @Override
  public String toString() {
    return "IntgCodeValdValDTO [intgCodeId=" + intgCodeId + ", intgCodeVal=" + intgCodeVal + ", intgCodeValNm=" + intgCodeValNm
        + ", rltoIntgCodeVal1=" + rltoIntgCodeVal1 + ", rltoIntgCodeVal2=" + rltoIntgCodeVal2 + ", starDate=" + starDate
        + ", endDate=" + endDate + ", otptOrdr=" + otptOrdr + ", istcCntn=" + istcCntn + "]";
  }

}
