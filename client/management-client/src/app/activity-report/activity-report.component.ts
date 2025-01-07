import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ActivityReport } from '../model/activityreport';
import { ActivityReportService } from '../activity-report-service/activity-report.service';
import { DatePipe, NgFor, NgIf } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatDivider, MatDividerModule } from '@angular/material/divider';

@Component({
  selector: 'app-activity-report',
  imports: [NgFor, NgIf, MatCardModule, MatGridListModule, DatePipe, MatIconModule, MatDividerModule],
  templateUrl: './activity-report.component.html',
  styleUrls: ['./activity-report.component.css'],
})
export class ActivityReportComponent implements OnInit {
  activityReports: ActivityReport[] = [];

  @Input()
  orderId: string | null = null;

  @Output()
  reportActivitiesEvent = new EventEmitter<[string, ActivityReport[]]>();

  constructor(
    private activityReportService: ActivityReportService
  ) { }

  ngOnInit(): void {
    if (this.orderId) {
      this.loadActivityReports(this.orderId);
    }
  }

  ngOnChanges(): void {
    if (this.orderId) {
      this.loadActivityReports(this.orderId);
    }
  }

  loadActivityReports(orderId: string): void {
    this.activityReportService.getActivityReportsByOrderId(orderId).subscribe({
      next: (data) => {
        this.activityReports = data;
        this.reportActivitiesEvent.emit([this.orderId ? this.orderId : "", this.activityReports]);
      },
      error: (error) => {
        console.error('Error fetching activity reports', error);
      },
    });
  }

}