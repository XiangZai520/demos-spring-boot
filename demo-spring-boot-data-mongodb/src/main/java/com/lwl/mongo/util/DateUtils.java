package com.lwl.mongo.util;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author lwl
 * @date 2018/10/18 16:46
 * @description
 */
public class DateUtils {
    public static final byte TYPE_AFTER = 0;
    public static final byte TYPE_BEFORE = 1;

    /**
     * localDate转Date
     */
    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * localDate转Date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取距离当前时间间隔多少天的时间
     */
    public static Date getSpecifiedTimeFromNow(int type, int days) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime resultDateTime = changeDate(type, days, localDateTime);
        assert resultDateTime != null;
        return localDateTimeToDate(resultDateTime);
    }

    /**
     * 获取距离指定间隔多少天的时间
     */
    public static Date getSpecifiedTimeFromBegin(int type, int days, Date begin) {
        LocalDateTime localDateTime = dateToLocalDateTime(begin);
        LocalDateTime resultDateTime = changeDate(type, days, localDateTime);
        assert resultDateTime != null;
        return localDateTimeToDate(resultDateTime);
    }

    private static LocalDateTime changeDate(int type, int days, LocalDateTime localDateTime) {
        switch (type) {
            case TYPE_AFTER:
                return localDateTime.plus(days, ChronoUnit.DAYS);
            case TYPE_BEFORE:
                return localDateTime.minus(days, ChronoUnit.DAYS);
            default:
                break;
        }
        return null;
    }

    /**
     *  date转localDateTime
     * */
    public static LocalDateTime dateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId);
    }
}