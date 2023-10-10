package com.hanwhalife.common.insr.core;

import com.hanwhalife.common.insr.core.dto.UserCtfnDTO;
import com.smart.core.util.ApplicationProperty;

import hlicp.ext.tele.constant.TeleConstant;
import hlicp.ext.tele.msg.HlicpMessageHeader;
import hlicp.ext.tele.msg.SimpleMessageEnvelop;

public class ChannelAdapterUtil {

    /**
     * 공통 ChannelAdapter
     */
    public ChannelAdapter getChannelAdapter() throws Exception {

        /**
         * 현재 프로필 조회
         */
        String activeProfile = System.getProperty("spring.profiles.active");

        String propertiesKey = "esb.insr.core.endpoint";

        if (activeProfile != null && activeProfile.length() > 0) {
            if ("local".equalsIgnoreCase(activeProfile) || "dev".equalsIgnoreCase(activeProfile) || "qa".equalsIgnoreCase(activeProfile)) {
                propertiesKey = propertiesKey + "." + activeProfile;
            }
        }

        /**
         * EIMS URL 조회
         */
        String targetUrl = ApplicationProperty.get(propertiesKey);

        /**
         * 채널 어댑터
         */
        ChannelAdapter channelAdapter = new ChannelAdapter(activeProfile, targetUrl);

        System.out.println("[ChannelAdapterUtil] activeProfile : " + activeProfile + ", targetUrl : " + targetUrl);

        return channelAdapter;
    }

    /**
     * SSO대체로그인인증
     */
    public SimpleMessageEnvelop<HlicpMessageHeader, UserCtfnDTO> getUserCtfn(UserCtfnDTO inputDTO) {

        SimpleMessageEnvelop<HlicpMessageHeader, UserCtfnDTO> output = null;

        try {
            /**
             * 채널 어댑터
             */
            ChannelAdapter channelAdapter = this.getChannelAdapter();

            /**
             * 헤더 설정
             */
            HlicpMessageHeader header = channelAdapter.createHeader("HLIHIP00015", "comItfcUserCtfnPSI001c", TeleConstant.INTERNAL_COM);

            output = channelAdapter.sendAndReceiveMessage(TeleConstant.TargetType.ESB, header, inputDTO, UserCtfnDTO.class);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return output;
    }

}
