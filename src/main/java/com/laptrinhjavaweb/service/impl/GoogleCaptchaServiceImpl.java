package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.constant.CaptchaConstant;
import com.laptrinhjavaweb.service.GoogleCaptchaService;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleCaptchaServiceImpl implements GoogleCaptchaService {


    @Override
    public boolean verifyGoogleCaptcha(String captchaResponse) {
        RestTemplate restTemplate = new RestTemplate();
        String params = "secret=" + CaptchaConstant.SECRETS_KEY + "&response=" + captchaResponse;
        String requestUrl = CaptchaConstant.GOOGLE_ENDPOINT_URL + "?" + params;

        String response = restTemplate.getForObject(requestUrl, String.class); ///Call API Cua Spring
        //==> {"success": true} or {"success": false}

        if (!StringUtils.isEmpty(response)){
            org.json.JSONObject jsonObject = new JSONObject(response);//chuyen Json String sang Object
            return jsonObject.getBoolean("success");
        }
        return false;
    }
}
