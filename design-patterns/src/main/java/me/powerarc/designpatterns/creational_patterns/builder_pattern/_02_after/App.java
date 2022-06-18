package me.powerarc.designpatterns.creational_patterns.builder_pattern._02_after;

import java.time.LocalDate;

import me.powerarc.designpatterns.creational_patterns.builder_pattern._01_before.TourPlan;

public class App {

	public static void main(String[] args) {
		TourPlanBuilder builder = new DefaultTourBuilder();
		TourPlan plan = builder.title("제주도")
			.nightsAndDays(2, 3)
			.startDate(LocalDate.of(2000, 12, 9))
			.whereToStay("호텔")
			.addPlan(0, "체크인")
			.addPlan(0, "식사")
			.getPlan();

		TourPlan longBeachTrip = builder.title("롱비치")
			.startDate(LocalDate.of(2021, 7, 15))
			.getPlan();

		// use Director
		TourDirector director = new TourDirector(new DefaultTourBuilder());
		TourPlan tourPlan = director.cancunTrip();
		TourPlan tourPlan1 = director.longBeachTrip();
	}
}
