package com.doan.student.controller;

import com.doan.student.payload.request.ResVnPay;
import com.doan.student.payload.response.RespPay;
import com.doan.student.service.impl.SerVnPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/pay")
public class ContVnPay {

    @Autowired
    SerVnPay serVnPay;
    private String queryParams;



    @RequestMapping(value = "/vnpay/createpay", method = RequestMethod.POST)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<Map<String, Object>> insSend( @RequestBody ResVnPay resVnPay)
    {
        Map<String, Object> response =  new HashMap<>();
         String data = serVnPay.sendVnPayload(resVnPay);
        queryParams = data;
        response.put("code", "00");
        response.put("message", "success");
        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/vnpay/ipn", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", maxAge = 3600)
//    @ResponseBody
    public ResponseEntity<Map<String, Object>> vnPaySend(@RequestParam Map<String, String> reqParam) throws UnsupportedEncodingException {
        Map<String, Object> response =  new HashMap<>();
        Map<String, String> dataParams = new HashMap<>();
        reqParam.forEach((String key, String data) -> {
            dataParams.put(key, data);
        });
        String data = serVnPay.vnPaySend(dataParams);
        if(data.equals("00")){
            response.put("message", "success");
        }
        else{
            response.put("message", "Fail checksum");
        }
        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/vnpay/return", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<Map<String, Object>> successPay(@RequestParam() Map<String, String> reqParam) throws UnsupportedEncodingException {

        Map<String, Object> response =  new HashMap<>();
        Map<String, String> dataParams = new HashMap<>();
        reqParam.forEach((String key, String data) -> {
            dataParams.put(key, data);
        });
        RespPay data = serVnPay.takePayLoad(dataParams);
        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
