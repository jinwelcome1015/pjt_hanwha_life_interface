package hlicp.sample;

import hlicp.ext.tele.ChannelAdapter;
import hlicp.ext.tele.constant.TeleConstant;
import hlicp.ext.tele.msg.HlicpMessageHeader;
import hlicp.sample.dto.IntgCodeDetlInqyInptDTO;
import hlicp.sample.dto.IntgCodeDetlInqyReturnDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestCaller2 {

    private static final Logger logger = LoggerFactory.getLogger(TestCaller2.class);


    public static void main(String[] args) {
        //----------------------------------------------------------------------------------------------------
        // 요청 파라미터 설정
        //----------------------------------------------------------------------------------------------------
        String itfcId = "HLIWUI03602";                   // 시스템 인터페이스ID
        String rcveSrvcId = "comIntgCodeSrchPSI002r";    // 수신 서비스 ID
        String rcveSysCode = TeleConstant.INTERNAL_COM;  // 수신 시스템 코드

        //----------------------------------------------------------------------------------------------------
        // ChannelAdapter 객체 생성
        //----------------------------------------------------------------------------------------------------
        ChannelAdapter channelAdapter = new ChannelAdapter();

        //----------------------------------------------------------------------------------------------------
        // 요청 header 생성
        //----------------------------------------------------------------------------------------------------
        HlicpMessageHeader header = channelAdapter.createHeader(itfcId, rcveSrvcId, rcveSysCode);
//        header.setPrsnInfoIncsYn("Y");  // 개인정보포함여부

        //----------------------------------------------------------------------------------------------------
        // 요청 Data 설정
        //----------------------------------------------------------------------------------------------------
        IntgCodeDetlInqyInptDTO inputDTO = new IntgCodeDetlInqyInptDTO();
        inputDTO.setIntgCodeId("PRSN_FNAF_TYPE_CODE");

        //----------------------------------------------------------------------------------------------------
        // 연계시스템 서비스 호출
        //----------------------------------------------------------------------------------------------------
        IntgCodeDetlInqyReturnDTO output = channelAdapter.sendAndReceive(TeleConstant.TargetType.MCI, header, inputDTO, IntgCodeDetlInqyReturnDTO.class);

        //----------------------------------------------------------------------------------------------------
        // 응답 Data 조회
        //----------------------------------------------------------------------------------------------------
        logger.debug(">>>>>>>>>> output: {}", output);
        System.out.printf(">>>>>>>>>> output: %s%n", output);
    }

}
