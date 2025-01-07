package dev.irmlerjo.management.activityreport;

import java.time.LocalDateTime;

public record ActivityReport(String id,String orderId, String description, String comment, LocalDateTime start, int duration) {
	
}
