package dev.irmlerjo.management.order;

import java.time.LocalDateTime;

import dev.irmlerjo.management.costreport.CostReport;

public record order(
		String id,
		String name,
		String description,
		CostReport costReport,
		LocalDateTime deliveryDate,
		Integer plannedHourlyBudget) {

}
