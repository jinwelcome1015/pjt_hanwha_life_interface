/**
 * COPYRIGHT ⓒ Hanwha Life Insurance  CO. LTD. All rights reserved.
 * 한화생명의 사전 승인 없이 본 내용의 전부 또는 일부에 대한 복사,배포,사용을 금합니다.
 */

package hlicp.sample.dto;

/**
 * 통합코드부분적용DTO
 * 
 * <pre>
 * 통합코드부분적용DTO
 * </pre>
 * 
 * @author 홍길동
 * @version 1.0
 * @since 2020.04.16 init
 * @modelClassKorName 통합코드부분적용DTO
 * @modelPackageKorName 02.프로세스서비스컴포넌트::01.기준정보::01.통합코드::01.통합코드검색PSI::DTO
 * @modelGenerated NOT
 */
public class IntgCodePrtlAplyDTO {

	/**
	 * 통합코드ID
	 * 
	 * @modelGenerated
	 */
	private String intgCodeId;

	/**
	 * 통합코드부분적용일련번호
	 * 
	 * @modelGenerated
	 */
	private int intgCodePrtlAplySqno;

	/**
	 * 통합코드부분적용명
	 * 
	 * @modelGenerated
	 */
	private String intgCodePrtlAplyNm;

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
	 * 통합코드부분적용일련번호 Get Method
	 * 
	 * @modelGenerated
	 */
	public int getIntgCodePrtlAplySqno() {
		return this.intgCodePrtlAplySqno;
	}

	/**
	 * 통합코드부분적용일련번호 Set Method
	 * 
	 * @modelGenerated
	 */
	public void setIntgCodePrtlAplySqno(int intgCodePrtlAplySqno) {
		this.intgCodePrtlAplySqno = intgCodePrtlAplySqno;
	}

	/**
	 * 통합코드부분적용명 Get Method
	 * 
	 * @modelGenerated
	 */
	public String getIntgCodePrtlAplyNm() {
		return this.intgCodePrtlAplyNm;
	}

	/**
	 * 통합코드부분적용명 Set Method
	 * 
	 * @modelGenerated
	 */
	public void setIntgCodePrtlAplyNm(String intgCodePrtlAplyNm) {
		this.intgCodePrtlAplyNm = intgCodePrtlAplyNm;
	}

	@Override
	public String toString() {
		return "IntgCodePrtlAplyDTO [intgCodeId=" + intgCodeId + ", intgCodePrtlAplySqno=" + intgCodePrtlAplySqno
				+ ", intgCodePrtlAplyNm=" + intgCodePrtlAplyNm + "]";
	}

}
