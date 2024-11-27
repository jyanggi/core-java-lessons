package lessons.v8.oca.chapter3.dates;

import java.time.*;
import java.util.Date;

import static java.lang.System.out;

public class LocalDateTimeSample1 {

    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now();
        out.println(localTime);
        out.println(localTime
                .plus(Duration.ofHours(5).plus(Duration.ofMinutes(30))));

        LocalDate localDate = LocalDate.of(2020, Month.JANUARY, 01);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        out.println(localDateTime);
        out.println(localDateTime.plus(Duration.ofDays(12)));

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime,
                ZoneId.systemDefault());
        Date d = Date.from(zonedDateTime.toInstant());
        out.println(d);
        out.println(localDate);
        out.println(LocalDate.of(2020, Month.JANUARY, 01)
                .isBefore(LocalDate.of(2019, Month.JANUARY, 01)));

        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
        System.out.println(dateTime); // 2016�03�13T01:30�05:00[US/Eastern]
        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); // 2016�03�13T03:30�04:00[US/Eastern]

        LocalDate dateFallBack = LocalDate.of(2016, Month.NOVEMBER, 6);
        LocalTime timeFallBack = LocalTime.of(1, 30);
        ZonedDateTime dateTimeFallBack = ZonedDateTime.of(dateFallBack,
                timeFallBack, zone);
        System.out.println(dateTimeFallBack); // 2016�11�06T01:30�04:00[US/Eastern]
        dateTimeFallBack = dateTimeFallBack.plusHours(1);
        System.out.println(dateTimeFallBack); // 2016�11�06T01:30�05:00[US/Eastern]
        dateTimeFallBack = dateTimeFallBack.plusHours(1);
        System.out.println(dateTimeFallBack); // 2016�11�06T02:30�05:00[US/Eastern]

    }

}
