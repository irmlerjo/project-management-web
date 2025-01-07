package dev.irmlerjo.management.activityreport;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class MockTimeTracking implements TimeTrackingInterface {

	private final List<ActivityReport> activityReports = new ArrayList<>();

	@Override
	public List<ActivityReport> getActivityReports(String orderId) {
		System.err.println("Reached");
		return activityReports.stream().filter(activityReport -> activityReport.orderId().equals(orderId)).toList();
	}

	@Override
	public int getRecordedHours(String orderId) {
		System.err.println("Reached");
		return activityReports.stream().filter(activityReport -> activityReport.orderId().equals(orderId)).mapToInt(ActivityReport::duration).sum();
	}
	
	@PostConstruct
	private void populateActivityReports() {
		this.activityReports.add(new ActivityReport("1","1", "Requirements", "Analyzed project requirements with client",  LocalDateTime.of(2024, 12, 20, 10, 0), 20));
		this.activityReports.add(new ActivityReport("2","1", "Development", "Setup Project and start development",  LocalDateTime.of(2024, 12, 21, 10, 0), 30));
		this.activityReports.add(new ActivityReport("3", "1", "Testing", "Performed unit testing and integration testing",  LocalDateTime.of(2024, 12, 22, 10, 0), 10));		
		this.activityReports.add(new ActivityReport("4", "2", "Design", "Created wireframes and initial UI mockups",  LocalDateTime.of(2024, 12, 20, 10, 0), 8));
		this.activityReports.add(new ActivityReport("5", "2", "Development", "Implemented core backend functionality", LocalDateTime.of(2024, 12, 19, 10, 0) , 12));
		this.activityReports.add(new ActivityReport("6", "3", "Deployment", "Set up CI/CD pipelines for deployment",  LocalDateTime.of(2024, 12, 17, 10, 0), 6));
		this.activityReports.add(new ActivityReport("7", "3", "Documentation", "Drafted technical documentation for API endpoints",  LocalDateTime.of(2024, 12, 16,10, 0), 4));
		this.activityReports.add(new ActivityReport("8", "3", "Maintenance", "Resolved bugs and performance issues",  LocalDateTime.of(2024, 12, 14, 10, 0), 7));
		this.activityReports.add(new ActivityReport("9", "3", "Client Review", "Conducted review session with stakeholders", LocalDateTime.of(2024, 12, 23, 10, 0), 3));
		this.activityReports.add(new ActivityReport("10", "3", "Refactoring", "Improved code quality and structure",  LocalDateTime.of(2024, 12, 21, 10, 0), 9));
	}

}
