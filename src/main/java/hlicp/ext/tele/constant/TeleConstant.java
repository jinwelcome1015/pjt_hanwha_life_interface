package hlicp.ext.tele.constant;

public class TeleConstant {

    public enum TargetType {
        MCI, ESB, FEP
    }

    /** 처리결과 구분코드 : 성공 */
    public static final String PRCS_RSLT_DVSN_CODE_SUCCESS = "0";
    /** 처리결과 구분코드 : 실패 */
    public static final String PRCS_RSLT_DVSN_CODE_FAIL = "1";

    /** 요청 응답 구분 코드 : 요청 */
    public static final String RSPN_DVSN_SEND = "S";
    /** 요청 응답 구분 코드 : 응답 */
    public static final String RSPN_DVSN_RECEIVE = "R";

    /** 요청 응답 구분 코드 : 요청 더미 응답 */
    public static final String RSPN_DVSN_SEND_DUMMY = "Q";
    /** 요청 응답 구분 코드 : 응답 더미 응답 */
    public static final String RSPN_DVSN_RECEIVE_DUMMY = "P";


    /** 운영서버 */
    public static final String SERVER_TYPE_PROD = "PROD";
    /** QA서버 */
    public static final String SERVER_TYPE_QA = "QA";
    /** 개발서버 */
    public static final String SERVER_TYPE_DEV = "DEV";
    /** 로컬서버 */
    public static final String SERVER_TYPE_LOCAL = "LOCAL";


    // 20201014 연계 시스템 기준 코드
    public static final String INTERNAL_ACT = "ACT"; // 계리결산
    public static final String INTERNAL_AFR = "AFR"; // 망분리 무선인증
    public static final String INTERNAL_AIP = "AIP"; // AI플랫폼
    public static final String INTERNAL_AIS = "AIS"; // 종합감사
    public static final String INTERNAL_AML = "AML"; // 자금세탁방지
    public static final String INTERNAL_ANY = "ANY"; // 대외계
    public static final String INTERNAL_API = "API"; // OPEN API
    public static final String INTERNAL_APM = "APM"; // APM
    public static final String INTERNAL_ARS = "ARS"; // ARS
    public static final String INTERNAL_AUT = "AUT"; // 오토시스
    public static final String INTERNAL_BAC = "BAC"; // 보험코어-입금
    public static final String INTERNAL_BCM = "BCM"; // 영업지원공통
    public static final String INTERNAL_BDS = "BDS"; // 빅데이터시스템
    public static final String INTERNAL_BFR = "BFR"; // 스마트기기 무선인증
    public static final String INTERNAL_BNC = "BNC"; // 방카슈랑스
    public static final String INTERNAL_BNW = "BNW"; // 방카슈랑스웹
    public static final String INTERNAL_BPM = "BPM"; // 융자BPM
    public static final String INTERNAL_BRN = "BRN"; // 브랜드
    public static final String INTERNAL_BSM = "BSM"; // 영업관리
    public static final String INTERNAL_BSP = "BSP"; // 영업지원
    public static final String INTERNAL_CAL = "CAL"; // 콜센터
    public static final String INTERNAL_CAM = "CAM"; // 콜센터 모니터링
    public static final String INTERNAL_CAN = "CAN"; // 콜센터 NR
    public static final String INTERNAL_CAR = "CAR"; // 콜센터 녹취청취웹
    public static final String INTERNAL_CAW = "CAW"; // 콜센터 WFM
    public static final String INTERNAL_CFC = "CFC"; // 클레임산출
    public static final String INTERNAL_CFP = "CFP"; // 보험코어-재지급산출
    public static final String INTERNAL_CFQ = "CFQ"; // 가입설계산출
    public static final String INTERNAL_CFV = "CFV"; // 변액산출
    public static final String INTERNAL_CGW = "CGW"; // CIRCLE-써클그룹웨어
    public static final String INTERNAL_CHE = "CHE"; // 보험코어-건강검진
    public static final String INTERNAL_CIC = "CIC"; // 중앙파일서버
    public static final String INTERNAL_CIR = "CIR"; // 써클그룹웨어
    public static final String INTERNAL_CLM = "CLM"; // 보험코어-클레임
    public static final String INTERNAL_CMC = "CMC"; // 산출공통
    public static final String INTERNAL_COB = "COB"; // 콜센터음성봇OB
    public static final String INTERNAL_COM = "COM"; // 보험코어-업무공통
    public static final String INTERNAL_COP = "COP"; // 보험코어-클레임지급
    public static final String INTERNAL_CRM = "CRM"; // 시장신용리스크관리
    public static final String INTERNAL_CTC = "CTC"; // 보험코어-계약변경
    public static final String INTERNAL_CUV = "CUV"; // 상품개발지원시스템(HCUVE)
    public static final String INTERNAL_CWM = "CWM"; // 콜센터 통계
    public static final String INTERNAL_DCH = "DCH"; // 데이터변경관리시스템
    public static final String INTERNAL_DEP = "DEP"; // 수탁
    public static final String INTERNAL_DLI = "DLI"; // 전자도서관
    public static final String INTERNAL_DRK = "DRK"; // 드림파크 웹
    public static final String INTERNAL_DRM = "DRM"; // DRM 문서관리
    public static final String INTERNAL_DTI = "DTI"; // 전자세금계산서
    public static final String INTERNAL_EAM = "EAM"; // 전사적아키텍터관리 시스템
    public static final String INTERNAL_EBP = "EBP"; // Eagle BPM
    public static final String INTERNAL_EBT = "EBT"; // ESB BATCH 시스템
    public static final String INTERNAL_ECS = "ECS"; // 이메일상담시스템
    public static final String INTERNAL_EDM = "EDM"; // 전자문서
    public static final String INTERNAL_EDW = "EDW"; // EDW포털
    public static final String INTERNAL_EEC = "EEC"; // 대표홈페이지(인터넷창구)
    public static final String INTERNAL_EFM = "EFM"; // EFMS
    public static final String INTERNAL_EHD = "EHD"; // 연수원교육사이트
    public static final String INTERNAL_EHP = "EHP"; // 대표홈페이지
    public static final String INTERNAL_EHR = "EHR"; // 신인사
    public static final String INTERNAL_EIR = "EIR"; // 대표홈페이지(개인형IRP)
    public static final String INTERNAL_EKM = "EKM"; // 콜센터 지식관리(이지샘)
    public static final String INTERNAL_ENI = "ENI"; // 에니시스
    public static final String INTERNAL_EPT = "EPT"; // Eagle Portal
    public static final String INTERNAL_ERI = "ERI"; // 대표홈페이지(퇴직보험창구)
    public static final String INTERNAL_ERP = "ERP"; // ERP
    public static final String INTERNAL_ERW = "ERW"; // 대표홈페이지(퇴직연금창구)
    public static final String INTERNAL_ESB = "ESB"; // ESB 내부인터페이스
    public static final String INTERNAL_ETW = "ETW"; // 촉탁의창구
    public static final String INTERNAL_FAM = "FAM"; // 투자전략
    public static final String INTERNAL_FAN = "FAN"; // 핀테크 분석서버
    public static final String INTERNAL_FDS = "FDS"; // 핀테크 FDS(사기방지시스템)
    public static final String INTERNAL_FHB = "FHB"; // 보험코어-재무HUB
    public static final String INTERNAL_FPH = "FPH"; // FP 홈페이지
    public static final String INTERNAL_FPI = "FPI"; // FP월드 내부
    public static final String INTERNAL_FPT = "FPT"; // FP 태블릿
    public static final String INTERNAL_FUN = "FUN"; // 수익증권
    public static final String INTERNAL_GCR = "GCR"; // GCRM
    public static final String INTERNAL_GMI = "GMI"; // 해외법인 경영정보
    public static final String INTERNAL_GZN = "GZN"; // PC매체제어시스템(가드존)
    public static final String INTERNAL_HAC = "HAC"; // HFS 경리회계
    public static final String INTERNAL_HAM = "HAM"; // 메뉴권한관리
    public static final String INTERNAL_HBI = "HBI"; // 한화생명재무정보시스템 BI/OLAP
    public static final String INTERNAL_HBP = "HBP"; // 빅데이터플렛폼
    public static final String INTERNAL_HCA = "HCA"; // 대고객 안내장 보안
    public static final String INTERNAL_HCH = "HCH"; // 변경관리
    public static final String INTERNAL_HCS = "HCS"; // 사고보험금심사지원지시스템
    public static final String INTERNAL_HCU = "HCU"; // 상품개발지원시스템
    public static final String INTERNAL_HEC = "HEC"; // 홈페이지(인터넷창구)
    public static final String INTERNAL_HEW = "HEW"; // 홈페이지(촉탁의창구)
    public static final String INTERNAL_HFC = "HFC"; // HFS 융자
    public static final String INTERNAL_HFI = "HFI"; // 한화라이프재무정보시스템
    public static final String INTERNAL_HFM = "HFM"; // FP 사이버 교육 모바일
    public static final String INTERNAL_HFP = "HFP"; // FP 사이버 교육
    public static final String INTERNAL_HFS = "HFS"; // HFS계정계
    public static final String INTERNAL_HFX = "HFX"; // 콜센터 팩스
    public static final String INTERNAL_HGA = "HGA"; // HFS 총무
    public static final String INTERNAL_HGS = "HGS"; // 신구매시스템
    public static final String INTERNAL_HIA = "HIA"; // 홈페이지(현업관리자)
    public static final String INTERNAL_HIP = "HIP"; // 통합교육플랫폼
    public static final String INTERNAL_HIR = "HIR"; // 홈페이지(개인형IRP)
    public static final String INTERNAL_HLI = "HLI"; // 서버내 개인정보 암호화 시스템
    public static final String INTERNAL_HLT = "HLT"; // HST(계리리스크통계)
    public static final String INTERNAL_HMO = "HMO"; // 영업포털 모니터링
    public static final String INTERNAL_HMP = "HMP"; // 영업포털
    public static final String INTERNAL_HOM = "HOM"; // 홈페이지
    public static final String INTERNAL_HPI = "HPI"; // 개인정보 파기 및 분리보관 시스템
    public static final String INTERNAL_HPM = "HPM"; // HFS 인사
    public static final String INTERNAL_HPR = "HPR"; // 프로젝트관리 시스템
    public static final String INTERNAL_HPS = "HPS"; // 출력물보안 시스템
    public static final String INTERNAL_HRI = "HRI"; // 홈페이지(퇴직연금창구)
    public static final String INTERNAL_HRP = "HRP"; // HFS 퇴직연금
    public static final String INTERNAL_HRT = "HRT"; // HFS 퇴직보험
    public static final String INTERNAL_HRW = "HRW"; // 홈페이지(퇴직보험창구)
    public static final String INTERNAL_HSE = "HSE"; // HFS 유가증권_일반계정
    public static final String INTERNAL_HSM = "HSM"; // 기업보안관리
    public static final String INTERNAL_HSP = "HSP"; // 스마트연수원
    public static final String INTERNAL_HSR = "HSR"; // HFS 유가증권_변액계정
    public static final String INTERNAL_HSY = "HSY"; // HFP 모바일 PT
    public static final String INTERNAL_HTS = "HTS"; // H-TOPS
    public static final String INTERNAL_IAM = "IAM"; // 계정관리시스템
    public static final String INTERNAL_IBC = "IBC"; // 보험코어-보험업무공통
    public static final String INTERNAL_ICM = "ICM"; // 통합고객관리
    public static final String INTERNAL_ICS = "ICS"; // 통합고객지원
    public static final String INTERNAL_IDM = "IDM"; // 대표홈페이지 현업관리자(인트라_DRM)
    public static final String INTERNAL_IFR = "IFR"; // 보험코어-보험사기
    public static final String INTERNAL_IMG = "IMG"; // 이미지
    public static final String INTERNAL_INI = "INI"; // 보험코어-통합안내장IF
    public static final String INTERNAL_INM = "INM"; // 보험코어-통합안내장
    public static final String INTERNAL_INT = "INT"; // 대표홈페이지 현업관리자(인트라)
    public static final String INTERNAL_IPM = "IPM"; // 보험코어-통합입출금
    public static final String INTERNAL_IPS = "IPS"; // 총무구매
    public static final String INTERNAL_IRL = "IRL"; // IFRS 대손
    public static final String INTERNAL_IRU = "IRU"; // IFRS 공통
    public static final String INTERNAL_IRV = "IRV"; // IFRS 평가
    public static final String INTERNAL_ITM = "ITM"; // IT자산관리
    public static final String INTERNAL_ITS = "ITS"; // IT자산관리
    public static final String INTERNAL_KCR = "KCR"; // ic칩 내장 카드 발급
    public static final String INTERNAL_KMS = "KMS"; // 지식관리
    public static final String INTERNAL_KNT = "KNT"; // KNET
    public static final String INTERNAL_LMS = "LMS"; // 법무관리
    public static final String INTERNAL_LPA = "LPA"; // 라이프플러스
    public static final String INTERNAL_MAM = "MAM"; // 모바일 IT자산관리
    public static final String INTERNAL_MCH = "MCH"; // 모바일 변경관리
    public static final String INTERNAL_MCI = "MCI"; // 모바일 고객관리통합
    public static final String INTERNAL_MCM = "MCM"; // 모바일 콜센터 모니터링
    public static final String INTERNAL_MDB = "MDB"; // 모바일대시보드
    public static final String INTERNAL_MDM = "MDM"; // 고객정보통합시스템
    public static final String INTERNAL_MFP = "MFP"; // FP SMART WORLD
    public static final String INTERNAL_MFS = "MFS"; // 메일필터 시스템
    public static final String INTERNAL_MGM = "MGM"; // 보험코어-사차관리
    public static final String INTERNAL_MHC = "MHC"; // Hone OP Center
    public static final String INTERNAL_MHM = "MHM"; // 모바일 홈페이지
    public static final String INTERNAL_MHS = "MHS"; // 모바일스마트연수원
    public static final String INTERNAL_MIC = "MIC"; // 모바일 통합창구
    public static final String INTERNAL_MIE = "MIE"; // 통합교육플랫폼 모바일
    public static final String INTERNAL_MIW = "MIW"; // 보험월렛
    public static final String INTERNAL_MKT = "MKT"; // 마케팅
    public static final String INTERNAL_MMM = "MMM"; // MCI내부거래
    public static final String INTERNAL_MOM = "MOM"; // Mobile MDM
    public static final String INTERNAL_MOS = "MOS"; // 미들오피스
    public static final String INTERNAL_MRM = "MRM"; // 보험코어-병력관리
    public static final String INTERNAL_MRP = "MRP"; // 퇴직연금 모바일(사업부)
    public static final String INTERNAL_MSE = "MSE"; // 스마트폰 전자청약
    public static final String INTERNAL_MSF = "MSF"; // 모바일SFA
    public static final String INTERNAL_MSP = "MSP"; // 모바일 스마트플래너
    public static final String INTERNAL_MWT = "MWT"; // 보험월렛2.0
    public static final String INTERNAL_NBM = "NBM"; // 미수채권관리
    public static final String INTERNAL_NCT = "NCT"; // 보험코어-신계약청약
    public static final String INTERNAL_NET = "NET"; // NetClient
    public static final String INTERNAL_OCR = "OCR"; // OCR이미지인식
    public static final String INTERNAL_OLP = "OLP"; // OLAP포털
    public static final String INTERNAL_ONS = "ONS"; // 온슈어(자가청약)
    public static final String INTERNAL_OTP = "OTP"; // OTP 서비스 시스템
    public static final String INTERNAL_OZS = "OZS"; // 오즈스케줄러
    public static final String INTERNAL_PAC = "PAC"; // PAPRICA-보험코어FW
    public static final String INTERNAL_PAD = "PAD"; // PAPRICA-기준정보관리
    public static final String INTERNAL_PAP = "PAP"; // PAPRICA-상품개발
    public static final String INTERNAL_PET = "PET"; // 반려견 입분양 매칭 시스템
    public static final String INTERNAL_QOT = "QOT"; // 보험코어-가입설계
    public static final String INTERNAL_RMS = "RMS"; // RMS(ESB 관리)
    public static final String INTERNAL_RPL = "RPL"; // 가입설계
    public static final String INTERNAL_RSC = "RSC"; // 재보험
    public static final String INTERNAL_RTP = "RTP"; // 퇴직연금
    public static final String INTERNAL_SLS = "SLS"; // 준법감시
    public static final String INTERNAL_SML = "SML"; // 보안메일 시스템
    public static final String INTERNAL_SMS = "SMS"; // 보안메일 전송 시스템
    public static final String INTERNAL_SOP = "SOP"; // 스마트인증시스템
    public static final String INTERNAL_SVP = "SVP"; // 보험코어-생존지급
    public static final String INTERNAL_TAM = "TAM"; // 통합자산관리
    public static final String INTERNAL_TMA = "TMA"; // 실시간메일
    public static final String INTERNAL_TMR = "TMR"; // TM센터 녹취청취
    public static final String INTERNAL_TMT = "TMT"; // 텔레마케팅
    public static final String INTERNAL_TRS = "TRS"; // 신탁
    public static final String INTERNAL_UDW = "UDW"; // 보험코어-언더라이팅
    public static final String INTERNAL_UMS = "UMS"; // 통합메시징 시스템
    public static final String INTERNAL_VMT = "VMT"; // VDI 모니터링
    public static final String INTERNAL_VOC = "VOC"; // 소리샘
    public static final String INTERNAL_VRE = "VRE"; // 녹취 통합관제
    public static final String INTERNAL_VRI = "VRI"; // 보험코어-변액
    public static final String INTERNAL_WLB = "WLB"; // PC통제
    public static final String INTERNAL_WLF = "WLF"; // 사회공헌
    public static final String INTERNAL_WLY = "WLY"; // WILY
    public static final String INTERNAL_ZZZ = "ZZZ"; // 전체공통
    public static final String EXTERNAL_A260 = "A260"; // 방카신한은행순전송
    public static final String EXTERNAL_ADB = "ADB"; // 채권추심(A&D)순전송
    public static final String EXTERNAL_AHA = "AHA"; // 방카현대스위스(SIB)저축순전송
    public static final String EXTERNAL_B350 = "B350"; // 방카제주은행역전송
    public static final String EXTERNAL_B370 = "B370"; // 방카전북은행역전송
    public static final String EXTERNAL_B810 = "B810"; // 방카하나은행역전송
    public static final String EXTERNAL_BBA = "BBA"; // 방카부산은행순전송
    public static final String EXTERNAL_CBA = "CBA"; // 방카씨티은행순전송
    public static final String EXTERNAL_CCM = "CCM"; // 신분증진위여부(쿠콘)역전송
    public static final String EXTERNAL_DBA = "DBA"; // 방카대구은행순전송
    public static final String EXTERNAL_DMB = "DMB"; // 방카더미S전송
    public static final String EXTERNAL_DMC = "DMC"; // 방카더미X전송
    public static final String EXTERNAL_DSA = "DSA"; // 방카대신증권순전송
    public static final String EXTERNAL_DYA = "DYA"; // 방카동양(유안타)증권순전송
    public static final String EXTERNAL_EBA = "EBA"; // 방카외환은행순전송
    public static final String EXTERNAL_EGB = "EGB"; // CMA연계신용대출(유진증권)순전송
    public static final String EXTERNAL_EGM = "EGM"; // CMA연계신용대출(유진증권)역전송
    public static final String EXTERNAL_FEP = "FEP"; // FEP 내부인터페이스
    public static final String EXTERNAL_FTB = "FTB"; // 공동FIDO(금융결제원) 순전송
    public static final String EXTERNAL_FTM = "FTM"; // 공동FIDO(금융결제원) 역전송
    public static final String EXTERNAL_GIK = "GIK"; // GIK
    public static final String EXTERNAL_GIM = "GIM"; // -실손보상(한국신용정보원)역전송
    public static final String EXTERNAL_GIN = "GIN"; // 보험계약정보(한국신용정보원 구클릭스)역전송
    public static final String EXTERNAL_GIO = "GIO"; // GIO
    public static final String EXTERNAL_GIP = "GIP"; // 보험신용정보(한국신용정보원)역전송
    public static final String EXTERNAL_GIQ = "GIQ"; // ICPS(한국신용정보원)역전송
    public static final String EXTERNAL_GIR = "GIR"; // -개인실손 중복조회(한국신용정보원)역전송
    public static final String EXTERNAL_GIS = "GIS"; // 실손시스템(한국신용정보원)역전송
    public static final String EXTERNAL_GIT = "GIT"; // 신용정보조회(한국신용정보원)역전송
    public static final String EXTERNAL_GIU = "GIU"; // ICPS자료등록 역전송
    public static final String EXTERNAL_GIV = "GIV"; // GIV
    public static final String EXTERNAL_HBA = "HBA"; // 방카하나은행순전송
    public static final String EXTERNAL_HBB = "HBB"; // RT펌뱅킹 하나은행 순전송(보전)
    public static final String EXTERNAL_HBC = "HBC"; // RT펌뱅킹 하나은행 순전송(수익)
    public static final String EXTERNAL_HBD = "HBD"; // 가상계좌 하나은행 순전송(수익)
    public static final String EXTERNAL_HBM = "HBM"; // RT펌뱅킹 하나은행 역전송(보전)
    public static final String EXTERNAL_HBN = "HBN"; // RT펌뱅킹 하나은행 역전송(수익)
    public static final String EXTERNAL_HBO = "HBO"; // 가상계좌 하나은행 역전송(수익)
    public static final String EXTERNAL_HCB = "HCB"; // CMA연계ATM이체(한화증권)순전송
    public static final String EXTERNAL_HCC = "HCC"; // CMA즉시이체업무(한화증권) 순전송
    public static final String EXTERNAL_HCD = "HCD"; // CMA연계신용대출(한화증권)순전송
    public static final String EXTERNAL_HCM = "HCM"; // CMA연계ATM이체(한화증권)역전송
    public static final String EXTERNAL_HCN = "HCN"; // CMA즉시이체업무(한화증권) 역전송
    public static final String EXTERNAL_HCO = "HCO"; // CMA연계신용대출(한화증권)역전송
    public static final String EXTERNAL_HDA = "HDA"; // 방카하나대투증권순전송
    public static final String EXTERNAL_HSA = "HSA"; // 방카한화투자증권순전송
    public static final String EXTERNAL_HWAC = "HWAC"; // 장내파생업무(한화증권)순전송
    public static final String EXTERNAL_HWAD = "HWAD"; // 장내파생업무(한화증권)역전송
    public static final String EXTERNAL_IBA = "IBA"; // 방카기업은행순전송
    public static final String EXTERNAL_IBL = "IBL"; // 방카기업은행역전송
    public static final String EXTERNAL_IIB = "IIB"; // 보험심사업무(한화손사)순전송
    public static final String EXTERNAL_IIC = "IIC"; // 보험심사업무서블릿(한화손사)순전송
    public static final String EXTERNAL_IIM = "IIM"; // 보험심사업무(한화손사)역전송
    public static final String EXTERNAL_JBA = "JBA"; // 방카전북은행순전송
    public static final String EXTERNAL_JJA = "JJA"; // 방카제주은행순전송
    public static final String EXTERNAL_JMB = "JMB"; // 방카JMAPP1
    public static final String EXTERNAL_JMC = "JMC"; // 방카JMAPP2
    public static final String EXTERNAL_JMD = "JMD"; // 방카JMAPP3
    public static final String EXTERNAL_JME = "JME"; // 방카JMAPP4
    public static final String EXTERNAL_JMF = "JMF"; // 방카JMAPP5
    public static final String EXTERNAL_JMG = "JMG"; // 방카JMAPP6
    public static final String EXTERNAL_JRA = "JRA"; // 방카제일은행순전송
    public static final String EXTERNAL_JRB = "JRB"; // RT펌뱅킹 제일은행 순전송
    public static final String EXTERNAL_JRM = "JRM"; // RT펌뱅킹 제일은행 역전송
    public static final String EXTERNAL_KBA = "KBA"; // 방카국민은행순전송
    public static final String EXTERNAL_KBB = "KBB"; // 방카국민은행POLL전문
    public static final String EXTERNAL_KBC = "KBC"; // RT펌뱅킹 국민은행 POLL
    public static final String EXTERNAL_KBN = "KBN"; // RT펌뱅킹 국민은행 역전송
    public static final String EXTERNAL_KCM = "KCM"; // 한국개인신용정보역전송
    public static final String EXTERNAL_KDA = "KDA"; // 방카산업은행순전송(tcp)
    public static final String EXTERNAL_KDB = "KDB"; // 방카산업은행순전송(SOAP)
    public static final String EXTERNAL_KFM = "KFM"; // 세금우대정보(은행연합회)역전송
    public static final String EXTERNAL_KIM = "KIM"; // 보험심사(보험개발원)_역전송
    public static final String EXTERNAL_KKA = "KKA"; // 방카케이뱅크순전송
    public static final String EXTERNAL_KLC = "KLC"; // 보험가입조회(생명보험협회)순전송
    public static final String EXTERNAL_KLE = "KLE"; // 변사자보험가입조회(생명보험협회)순전송
    public static final String EXTERNAL_KLM = "KLM"; // 모집조직관리(생명보험협회)역전송
    public static final String EXTERNAL_KLN = "KLN"; // 보험가입조회(생명보험협회)역전송
    public static final String EXTERNAL_KLO = "KLO"; // 휴면보험금(생명보험협회)역전송
    public static final String EXTERNAL_KLP = "KLP"; // 변사자보험가입조회(생명보험협회)역전송
    public static final String EXTERNAL_KNC = "KNC"; // 가상계좌 KSNET 순전송
    public static final String EXTERNAL_KND = "KND"; // 가상계좌 KSNET 순전송(미수채권)
    public static final String EXTERNAL_KNM = "KNM"; // 즉시이체(KSNET)역전송
    public static final String EXTERNAL_KNN = "KNN"; // 가상계좌 KSNET 역전송
    public static final String EXTERNAL_KOB = "KOB"; // 신종가(코스콤)_순전송
    public static final String EXTERNAL_KOC = "KOC"; // 채권(코스콤)_순전송
    public static final String EXTERNAL_KSA = "KSA"; // 방카현대(KB국민)증권순전송
    public static final String EXTERNAL_KSB = "KSB"; // CMA연계신용대출(현대증권)순전송
    public static final String EXTERNAL_KSM = "KSM"; // CMA연계신용대출(현대증권)역전송
    public static final String EXTERNAL_MAA = "MAA"; // 방카대우(미래에셋대우)증권순전송
    public static final String EXTERNAL_NBA = "NBA"; // 방카농협은행POLL전문
    public static final String EXTERNAL_NBB = "NBB"; // 가상계좌 농협은행 순전송(융자)
    public static final String EXTERNAL_NBM = "NBM"; // 가상계좌 농협은행 역전송(융자)
    public static final String EXTERNAL_NCA = "NCA"; // 방카농협중앙회POLL전문
    public static final String EXTERNAL_NHA = "NHA"; // 방카농협순전송
    public static final String EXTERNAL_NHSA = "NHSA"; // 방카농협증권순전송
    public static final String EXTERNAL_NIM = "NIM"; // 신용정보업무(NICE평가정보)융자_역전송
    public static final String EXTERNAL_NIN = "NIN"; // 실시간대출조회(NICE평가정보)융자_역전송
    public static final String EXTERNAL_NIO = "NIO"; // 신용등급확인(NICE평가정보)신계약_역전송
    public static final String EXTERNAL_NIP = "NIP"; // EBIZ고객업무(NICE평가정보)고객_역전송
    public static final String EXTERNAL_NIQ = "NIQ"; // 신용정보(NICE평가정보)융자_역전송
    public static final String EXTERNAL_NIR = "NIR"; // 장기연체조회(SafeKey)채널_역전송
    public static final String EXTERNAL_NIS = "NIS"; // MOBILE명의자인증 역전송
    public static final String EXTERNAL_OTM = "OTM"; // 안심번호서비스 역전송
    public static final String EXTERNAL_PNAN = "PNAN"; // 가상계좌 농협은행 POLL전문(융자)
    public static final String EXTERNAL_PRFA = "PRFA"; // 푸르덴셜HFN업무 순전송
    public static final String EXTERNAL_PRFB = "PRFB"; // 푸르덴셜HFN업무 역전송
    public static final String EXTERNAL_QNAN = "QNAN"; // 가상계좌 농협은행 POLL순전송(융자)
    public static final String EXTERNAL_RETI = "RETI"; // 퇴직연금(Commlayer)
    public static final String EXTERNAL_SBA = "SBA"; // 방카조흥(신한)은행순전송
    public static final String EXTERNAL_SBB = "SBB"; // RT펌뱅킹 신한은행 순전송
    public static final String EXTERNAL_SBL = "SBL"; // 방카조흥(신한)은행역전송
    public static final String EXTERNAL_SBM = "SBM"; // RT펌뱅킹 신한은행 역전송
    public static final String EXTERNAL_SCB = "SCB"; // 간편신청업무(신한카드)순전송
    public static final String EXTERNAL_SCM = "SCM"; // 간편신청업무(신한카드)역전송
    public static final String EXTERNAL_SIM = "SIM"; // 모기지보험(MI) 역전송
    public static final String EXTERNAL_SIN = "SIN"; // 모기지보험(MI) 역전송_B
    public static final String EXTERNAL_SIO = "SIO"; // 모기지보험(MI) 역전송_M
    public static final String EXTERNAL_SIP = "SIP"; // 모기지신용보험(MCI)역전송
    public static final String EXTERNAL_SIQ = "SIQ"; // 모기지신용보험(MCI)역전송_B
    public static final String EXTERNAL_SIR = "SIR"; // 모기지신용보험(MCI)역전송_M
    public static final String EXTERNAL_SIS = "SIS"; // 오토론전환대출(서울보증보험)역전송
    public static final String EXTERNAL_SIT = "SIT"; // 오토론중고차(서울보증보험)역전송
    public static final String EXTERNAL_SIU = "SIU"; // 오토론신차(서울보증보험)역전송
    public static final String EXTERNAL_SIV = "SIV"; // 전세자금대출 역전송
    public static final String EXTERNAL_SKA = "SKA"; // 방카신한투자증권순전송
    public static final String EXTERNAL_SSA = "SSA"; // 방카삼성증권순전송
    public static final String EXTERNAL_TFA = "TFA"; // 방카한국투자증권순전송
    public static final String EXTERNAL_WBA = "WBA"; // 방카우리은행순전송
    public static final String EXTERNAL_WBB = "WBB"; // RT펌뱅킹 우리은행 순전송(보전)
    public static final String EXTERNAL_WBC = "WBC"; // RT펌뱅킹 우리은행 순전송(신탁)
    public static final String EXTERNAL_WBD = "WBD"; // 가상계좌 우리은행 순전송(신탁)
    public static final String EXTERNAL_WBE = "WBE"; // 가상계좌 우리은행 순전송(요금)
    public static final String EXTERNAL_WBL = "WBL"; // 방카우리은행역전송
    public static final String EXTERNAL_WBM = "WBM"; // RT펌뱅킹(우리은행)보전_역전송
    public static final String EXTERNAL_WBN = "WBN"; // RT펌뱅킹(우리은행)신탁_역전송
    public static final String EXTERNAL_WBO = "WBO"; // 가상계좌 우리은행 역전송(신탁)
    public static final String EXTERNAL_WBP = "WBP"; // 가상계좌 우리은행 역전송(요금)
    public static final String EXTERNAL_WRFZ = "WRFZ"; // RT(우리은행)펌뱅킹 순전송2
    public static final String CHANNEL_LSI = "LSI"; // 보험코어-LSI
    public static final String CHANNEL_WUI = "WUI"; // 보험코어-UI
    public static final String INTEGRATION_MCI = "MCI"; // MCI(멀티채널통합)

}
