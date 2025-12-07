package com.zp.xc.common.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * TestDateTime
 *
 * @author zhengpanone
 * @since 2022-08-18
 */

public class TestDateTime {
   @Test
    public void TestLocalDate(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        System.out.println("year:"+year+"\tmonth:"+month+"\tday:"+day);
    }
    @Test
    public void TestLocalDateOf(){
        LocalDate of = LocalDate.of(2022, 8, 18);
        System.out.println("自定义日期："+of);
    }
}
