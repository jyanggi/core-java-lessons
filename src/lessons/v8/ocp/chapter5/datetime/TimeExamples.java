package lessons.v8.ocp.chapter5.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TimeExamples {



    public static void main(String []args){

        LocalDate now= LocalDate.now();
        System.out.println(now);
        LocalDate after1Month = now.plusMonths(1);
        System.out.println(after1Month);
        System.out.println(after1Month.isAfter(now));
        System.out.println(after1Month.plus(Period.of(1,1,1)));
        System.out.println(LocalDateTime.now().plus(Duration.ofDays(12)));
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.toInstant());
        System.out.println(new Date(zonedDateTime.toInstant().toEpochMilli()));


        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
        System.out.println(dateTime); // 2016–03–13T01:30–05:00[US/Eastern]
        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]

    }
}
