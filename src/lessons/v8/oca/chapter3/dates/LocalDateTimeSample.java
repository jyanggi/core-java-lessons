package lessons.v8.oca.chapter3.dates;

import java.time.*;

import static java.lang.System.out;

public class LocalDateTimeSample {

    public static void main(String[] args) {

        out.println(LocalDate.now());
        out.println(LocalTime.now());
        out.println(LocalDateTime.now());
        out.println(ZonedDateTime.now());
        LocalDate localDate = LocalDate.of(2020, Month.JANUARY, 31);
        out.println(
                localDate.plusDays(3).plusMonths(2).plusYears(1).plusWeeks(5));
        out.println(localDate);
        LocalTime localTime = LocalTime.of(6, 30, 23);
        out.println(localTime.plusHours(5).plusMinutes(45).plusSeconds(12));
        out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        out.println(Period.of(1, 2, 3));
        out.println(
                localDateTime.plus(Period.ofYears(12).plus(Period.ofDays(4))));
        out.println(localDateTime);

        ZoneId zoneId = ZoneId.of("Etc/GMT+8");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        out.println(zonedDateTime);
        out.println(ZoneId.systemDefault());
        out.println(ZoneId.getAvailableZoneIds());
    }
}
