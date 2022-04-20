package com.company;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        UseDateTimeFormatter useDateTimeFormatter = new UseDateTimeFormatter();
        LocalDateTime localDateTime = LocalDateTime.now();  // Bad practice
        String temp = useDateTimeFormatter.formatAsIsoDate(localDateTime);
        System.out.println("LocalDateTime.now: " + temp);

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("ZoneId: " + zoneId);

        LocalDateTime now = LocalDateTime.now(zoneId);  // Best practice
        System.out.println("LocalDateTime.now by zoneId: " + now);

        LocalDateTime tomorrow = now.plusDays(1);
        System.out.println("tomorrow: " + tomorrow);

        LocalDateTime previousMonthSameDay = now.minus(1, ChronoUnit.MONTHS);
        System.out.println("previousMonthSameDay: " + previousMonthSameDay);

        DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
        System.out.println("DayOfWeek: " + sunday);

        int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();
        System.out.println("DayOfMonth: " + twelve);

        ZoneId zoneIdParis = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneIdParis);
        System.out.println("zonedDateTime: " + zonedDateTime);

        LocalDate initialDate = LocalDate.parse("2007-05-10");
        LocalDate finalDate = initialDate.plus(Period.ofDays(5));
        System.out.println("finalDate calculated by Period class: " + finalDate);

        long periodDiff = ChronoUnit.DAYS.between(initialDate, finalDate);
        System.out.println("periodDiff: " + periodDiff);

        LocalTime initialTime = LocalTime.of(6, 30, 0);
        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
        System.out.println("finalTime calculated by Period class: " + finalTime);

        Date date = new Date();
        LocalDateTime localDateTimeCompatibleByDate = LocalDateTime.ofInstant(date.toInstant(), zoneId);
        System.out.println("localDateTimeCompatibleByDate: " + localDateTimeCompatibleByDate);

        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("DateTimeFormatter: " + format);
    }
}
