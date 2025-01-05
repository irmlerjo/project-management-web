package dev.irmlerjo.management.costreport;

public record FixedPriceCostReport(double fixedPrice) implements CostReport {

	public double calculatePrice(int hoursLogged) {
		return fixedPrice;
	}
}
