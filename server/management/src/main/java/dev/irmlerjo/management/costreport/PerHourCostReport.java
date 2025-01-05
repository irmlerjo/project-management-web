package dev.irmlerjo.management.costreport;

public record PerHourCostReport(double hourlyRateBeforeTax) implements CostReport {
	@Override
	public double calculatePrice(int hoursLogged) {
		return Double.valueOf(hoursLogged) * hourlyRateBeforeTax;
	}
}
