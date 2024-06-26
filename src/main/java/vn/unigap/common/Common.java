package vn.unigap.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Common {
    public static Date currentTime() {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date stringToDate(String value)  {
        try{
            SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return originalFormat.parse(value);
        }catch (java.text.ParseException e){
            return  currentTime();
        }

    }

    public static String listIntToString(List<Integer> list){
      return  list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("-", "-", "-"));
    }
}
