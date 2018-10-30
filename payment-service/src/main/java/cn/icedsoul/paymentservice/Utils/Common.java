package cn.icedsoul.paymentservice.Utils;

import java.sql.Timestamp;

public class Common {
    public static boolean isNull(Object obj){
        if(obj == null)
            return false;
        return true;
    }

    public static Timestamp getCurrentTime(){
        return new Timestamp(System.currentTimeMillis());
    }
}
