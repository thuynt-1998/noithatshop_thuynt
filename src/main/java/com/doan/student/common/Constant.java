package com.doan.student.common;

public class Constant {
    public static final  String ACTIVE="active";
    public  static  final  String STOP ="stop";

    public static  final  String COMPLETE= "complete";
//   đặt hàng và đã thanh toán
    public static  final String PREPARINGANDUNPAID= "preparingandunpaid";
    public  static final String CREATEBillANDUNPAID="createbillandunpaid";
    public  static final  String TRANSPORTANDUNPAID= "transportandunpaid";
    public static  final  String TRANSPORTINGANDUNPAID="transportingandunpaid";
    public  static  final  String ORDERANDUNPAID="orderandunpaid";
//    đặt hàng nhưng chưa thanh toán
    public static final String ORDER="order";
    public static  final String PREPARING= "preparing";
    public  static final String CREATEBill="createbill";
    public  static final  String TRANSPORT= "transport";
    public static  final  String TRANSPORTING="transporting";
//    trạng thái kiểm tra
    public static final  String EXCEPTION= "exception";
    public static final String YES= "yes";
    public static  final  String NO= "no";
    public static  final String EXISTS="exists";

    public static final String convertCode(String prevCode, String prefix){

        Integer numberCode=Integer.parseInt( number(prevCode)) +1;
        String code="";
       switch (numberCode.toString().length()){
           case 1:
            code="0000";
            break;
           case 2:
               code="000";
               break;
           case 3:
               code="00";
               break;
           case 4 :
               code="0";
               break;
          default:
              code="";
              break;
       }

        return prefix+code+numberCode.toString();
    }
    public static String number(String code){
        try{
            String[] codePrev= code.split("-");
            return  codePrev[codePrev.length-1];
        }
        catch (Exception e){
            return "-1";
        }

    }
}
