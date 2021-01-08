package com.doan.student.service.impl;

import com.doan.student.config.ConfigVnPay;
import com.doan.student.payload.request.ResVnPay;
import com.doan.student.payload.response.RespPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SerVnPay {



    public String sendVnPayload(ResVnPay resVnPay) {
        String vnp_Version = "2.0.0";
        String vnp_Command = "pay";
        String vnp_OrderInfo = resVnPay.getOrderInfo();
        String orderType = resVnPay.getOrderType();
        String vnp_TxnRef = ConfigVnPay.getRandomNumber(8);
        String vnp_IpAddr = resVnPay.getIpAddress();
        String vnp_TmnCode = ConfigVnPay.vnp_TmnCode;
        String vnp_hashSecret = ConfigVnPay.vnp_HashSecret;
        int amount = Integer.parseInt(resVnPay.getAmount()) * 100;
        Map<String, String> vnp_Params = new HashMap();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
        String bank_code = resVnPay.getBankCode();
        if (bank_code != null && bank_code.isEmpty()) {
            vnp_Params.put("vnp_BankCode", bank_code);
        }

        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
        vnp_Params.put("vnp_OrderType", orderType);
        String locate = resVnPay.getLanguage();
        if (locate != null && !locate.isEmpty()) {
            vnp_Params.put("vnp_Locale", locate);
        } else {
            vnp_Params.put("vnp_Locale", "vn");
        }

        vnp_Params.put("vnp_ReturnUrl", ConfigVnPay.vnp_Returnurl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
        Date dt = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(dt);
        vnp_Params.put("vnp_CreateDate", dateString);
        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();

        try {
            String fieldName;
            String fieldValue;
            while (itr.hasNext()) {
                fieldName = (String) itr.next();
                fieldValue = (String) vnp_Params.get(fieldName);
                if (fieldValue != null && fieldValue.length() > 0) {
                    hashData.append(fieldName);
                    hashData.append('=');
                    hashData.append(fieldValue);
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                    query.append('=');
                    query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    if (itr.hasNext()) {
                        query.append('&');
                        hashData.append('&');
                    }
                }
            }
            fieldName = query.toString();
            String var10000 = vnp_hashSecret;
            fieldValue = ConfigVnPay.Sha256(var10000 + hashData.toString());
            fieldName = fieldName + "&vnp_SecureHashType=SHA256&vnp_SecureHash=" + fieldValue;
            String paymentUrl = ConfigVnPay.vnp_PayUrl + "?" + fieldName;
            return paymentUrl;
        }
        catch (Exception e){
            return  e.getMessage();
        }
    }


    public String vnPaySend(Map<String, String> reqParam) throws UnsupportedEncodingException {
        String RspCode;
        Map<String, String> dataOrder = new HashMap<>();
        String vnp_SecureHash = reqParam.get("vnp_SecureHash");
        if (reqParam.containsKey("vnp_SecureHashType")) {
            reqParam.remove("vnp_SecureHashType");
        }
        if (reqParam.containsKey("vnp_SecureHash")) {
            reqParam.remove("vnp_SecureHash");
        }
        String signValue = ConfigVnPay.hashAllFields(reqParam);
        String ResponseCode = reqParam.get("vnp_ResponseCode");
        String orderInfo = reqParam.get("vnp_OrderInfo");
       
        String str[] = orderInfo.split(",");
        for(String s : str) {
            String data[] = s.split(":");
            dataOrder.put(data[0],data[1]);
        }

        if (vnp_SecureHash.equals(signValue)) {
            if ("00".equals(ResponseCode)) {
                // xu lý trạng thái đơn hàng khi thanh toasn thành công
            }
            else{

            }
            RspCode="00";
        }
         else {
            RspCode= "97";
        }
        return RspCode;
    }

    public RespPay takePayLoad(Map<String, String> reqParam) throws UnsupportedEncodingException {
        RespPay data = new RespPay();
        Map<String, String> dataOrder = new HashMap<>();
        String vnp_SecureHash = reqParam.get("vnp_SecureHash");
        if (reqParam.containsKey("vnp_SecureHashType")) {
            reqParam.remove("vnp_SecureHashType");
        }
        if (reqParam.containsKey("vnp_SecureHash")) {
            reqParam.remove("vnp_SecureHash");
        }
        String signValue = ConfigVnPay.hashAllFields(reqParam);
        String orderInfo = reqParam.get("vnp_OrderInfo");
        String ResponseCode = reqParam.get("vnp_ResponseCode");
        String str[] = orderInfo.split(",");
        for(String s : str) {
            String dataInfo[] = s.split(":");
            dataOrder.put(dataInfo[0],dataInfo[1]);
        }

        if (signValue.equals(vnp_SecureHash)) {
            if ("00".equals(ResponseCode)) {
             
                data.setMessage("Thanh toán thành công !!");
            } else {
                
                data.setMessage("Thanh toán thất bại !!");
            }
        }
        else {
            
            data.setMessage("Có lỗi xảy ra !!");
        }
        return data;
    }


}
