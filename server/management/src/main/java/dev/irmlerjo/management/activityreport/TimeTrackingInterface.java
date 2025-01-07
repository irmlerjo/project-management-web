package dev.irmlerjo.management.activityreport;

import java.util.List;

public interface TimeTrackingInterface {
	public List<ActivityReport> getActivityReports(String orderId);
	public int getRecordedHours(String orderId);
	

}
