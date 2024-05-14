package vn.unigap.common;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Common {
    public static Date currentTime() {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }
}
