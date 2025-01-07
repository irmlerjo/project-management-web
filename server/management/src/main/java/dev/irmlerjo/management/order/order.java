package dev.irmlerjo.management.order;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import dev.irmlerjo.management.costreport.FixedPriceCostReport;
import dev.irmlerjo.management.costreport.PerHourCostReport;

public record Order(String id, String projectId, String name, String description,
		FixedPriceCostReport fixedPriceCostReport, PerHourCostReport perHourCostReport,
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime deliveryDate,
		Integer plannedHourlyBudget) {

	public Order(String id, Order order) {
		this(id, order.projectId(), order.name(), order.description(), order.fixedPriceCostReport(),
				order.perHourCostReport(), order.deliveryDate(), order.plannedHourlyBudget());
	}
}
