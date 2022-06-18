package me.powerarc.designpatterns.creational_patterns.builder_pattern._02_after;

import java.time.LocalDate;

import me.powerarc.designpatterns.creational_patterns.builder_pattern._01_before.TourPlan;

public interface TourPlanBuilder {

	TourPlanBuilder nightsAndDays(int nights, int days);

	TourPlanBuilder title(String title);

	TourPlanBuilder startDate(LocalDate localDate);

	TourPlanBuilder whereToStay(String whereToStay);

	TourPlanBuilder addPlan(int day, String plan);

	TourPlan getPlan();
}
