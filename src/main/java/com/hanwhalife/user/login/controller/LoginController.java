package com.hanwhalife.user.login.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanwhalife.common.insr.core.ChannelAdapterUtil;
import com.hanwhalife.common.insr.core.dto.UserCtfnDTO;
import com.smart.core.util.RSAUtil;

import korealife.uv.com.cm.SHA256CmCrypt;

@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private RSAUtil rsaUtil;

    /**
     * 로그인 페이지 이동
     */
    @RequestMapping(value = "/user/login/loginForm.do", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelMap loginInit(final HttpServletRequest request, final ModelMap model) throws Exception {

        Map<String, String> rsaMap = rsaUtil.initRSA(request.getSession());

        if (rsaMap != null && !rsaMap.isEmpty()) {
            model.put("rsaTimestamp", rsaMap.get("rsaTimestamp"));
            model.put("rsaPublicKeyBase64", rsaMap.get("rsaPublicKeyBase64"));
        }

        return model;
    }

    /**
     * 로그인 프로세스
     */
    @ResponseBody
    @RequestMapping(value = "/user/login/ajax/login.do", method = { RequestMethod.GET, RequestMethod.POST })
    public Map<String, Object> login(final HttpServletRequest request, final HttpServletResponse response) throws Exception {

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("isSuccess", false);

        String rsaTimestamp = request.getParameter("rsaTimestamp");
        String rsaTimestampSession = (String) request.getSession().getAttribute("rsaTimestamp");

        if (rsaTimestamp != null && rsaTimestamp.length() > 0) {
            if (rsaTimestampSession == null || rsaTimestampSession.length() == 0) { // 세션만료
                return model;
            }

            if (!rsaTimestamp.equals(rsaTimestampSession)) { // 새로발행된 Key 가 존재
                return model;
            }
        }

        UserCtfnDTO UserCtfnParam = new UserCtfnDTO();
        UserCtfnParam.setEmnb(request.getParameter("memberNo"));

        try {
            String rsaPrivateKeyBase64 = (String) request.getSession().getAttribute("rsaPrivateKeyBase64"); // 비밀키 취득
            if (rsaPrivateKeyBase64 != null && rsaPrivateKeyBase64.length() > 0) {
                String passwordEnc = request.getParameter("password");
                String passwordDec = rsaUtil.decrypt(passwordEnc, rsaPrivateKeyBase64);

                UserCtfnParam.setLognPswd(SHA256CmCrypt.SHA256_getEncString(passwordDec));
            }
        } catch (Exception e) {
            LOGGER.error("rsaUtil.decrypt", e);
            return model;
        }

        ChannelAdapterUtil channelAdapterUtil = new ChannelAdapterUtil();

        /**
         * SSO 인증 대체
         */
        UserCtfnDTO userCtfnDTO = channelAdapterUtil.getUserCtfn(UserCtfnParam).getPayload();

        if ("01".equals(userCtfnDTO.getRspnCodeVal())) {
            model.put("isSuccess", true);

        } else {
            LOGGER.error("rspnCodeVal : {}, rspnMsgeCntn : {}", userCtfnDTO.getRspnCodeVal(), userCtfnDTO.getRspnMsgeCntn());

        }

        return model;
    }

}
