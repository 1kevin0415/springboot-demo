package com.neusoft.neu23.tc;

import java.time.LocalDateTime;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
 public class DateTimeTools {

//    向大模型报告函数的功能
    @Tool(description = "返回用户所在时区的日期和时间")

    String getCurrentDateTime() {
        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
    }

}