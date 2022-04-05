package me.powerarc.java8to11.date;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App {
	public static void main(String[] args) throws InterruptedException {
		Instant instant = Instant.now();
		System.out.println(instant);

		ZoneId zone = ZoneId.systemDefault();
		System.out.println(zone);
		ZonedDateTime zonedDateTime = instant.atZone(zone);
		System.out.println(zonedDateTime);

		System.out.println("======================\n");

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime plus1 = now.plus(10, ChronoUnit.DAYS);
		System.out.println(now);
		System.out.println(plus1);

		LocalDateTime birthDay = LocalDateTime.of(1997, Month.JANUARY, 28, 0, 0, 0, 0);
		ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

		System.out.println("======================\n");

		LocalDate today = LocalDate.now();
		LocalDate nextBirthDay = LocalDate.of(2023, Month.JANUARY, 28);

		Period between = Period.between(today, nextBirthDay);
		System.out.println(between.getDays());

		Period until = today.until(nextBirthDay);
		System.out.println(until.get(ChronoUnit.DAYS));

		System.out.println("======================\n");

		Instant now1 = Instant.now();
		Instant plus = now1.plus(10, ChronoUnit.SECONDS);
		Duration between1 = Duration.between(now1, plus);
		System.out.println(between1.getSeconds());

		System.out.println("======================\n");

		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.println(time.format(formatter));

		LocalDate parse = LocalDate.parse("07/15/1982", formatter);
		System.out.println(parse);

		System.out.println("======================\n");

		Date date = new Date();
		Instant toInstant = date.toInstant();
		Date from = Date.from(toInstant);

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		ZonedDateTime zonedDateTime1 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
		GregorianCalendar from1 = GregorianCalendar.from(zonedDateTime1);

		ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
		TimeZone timeZone = TimeZone.getTimeZone(zoneId);
	}
}
