package dev.irmlerjo.management.activityreport;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activityreports")
public class ActivityReportController {
	private final TimeTrackingInterface timetracking;

	public ActivityReportController(MockTimeTracking mockTimeTracking) {
		timetracking = mockTimeTracking;
	}
	
	@GetMapping("{orderId}")
	public List<ActivityReport> findAllActivityReports(@PathVariable String orderId) {
		return timetracking.getActivityReports(orderId);
	}
	
	@GetMapping("/hours/{orderId}")
	public int sumActivityReports(@PathVariable String orderId) {
		return timetracking.getRecordedHours(orderId);
	}

}
