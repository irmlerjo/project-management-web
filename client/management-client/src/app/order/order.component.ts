import { Component, Input, OnInit, SimpleChanges } from '@angular/core';
import { OrderService } from '../order-service/order.service';
import { Order } from '../model/order';
import { DatePipe, NgClass, NgFor, NgIf } from '@angular/common';
import { ActivityReportComponent } from "../activity-report/activity-report.component";
import { MatCardModule } from '@angular/material/card';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { MatAccordion, MatExpansionModule } from '@angular/material/expansion';
import { MatGridListModule } from '@angular/material/grid-list';
import { ActivityReport } from '../model/activityreport';
@Component({
  selector: 'app-order',
  imports: [NgIf, NgFor, NgClass, ActivityReportComponent, MatCardModule, MatListModule, MatIconModule, MatAccordion, MatExpansionModule, DatePipe, MatGridListModule],
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css'],
})
export class OrderComponent implements OnInit {
  orders: Order[] = [];
  selectedOrder: Order | null = null;
  today = new Date(Date.now());

  // Todo: Move this to Cost-warning service.
  criticalCostFactor: number = 0.8;

  totalHours: number = 0;

  @Input()
  projectId: string | null = null;

  constructor(
    private orderService: OrderService
  ) { }

  ngOnInit(): void {
    if (this.projectId) {
      this.loadOrders(this.projectId);
    }
  }

  ngOnChanges(changes: SimpleChanges) {
    this.selectedOrder = null;
    if (this.projectId) {
      this.loadOrders(this.projectId);
    }
  }

  loadOrders(projectId: string): void {
    this.orderService.getOrdersByProjectId(projectId).subscribe({
      next: (data) => {
        this.orders = data;
      },
      error: (error) => {
        console.error('Error fetching orders', error);
      },
    });
  }

  onOrderClick(order: Order) {
    this.selectedOrder = order;
  }

  getOrderById(id: string): Order | undefined {
    return this.orders.find((order) => order.id == id);
  }

  hourDeadlineCritical(order: Order): boolean {
    if (order.currentHours) {
      return order.currentHours > order.plannedHourlyBudget * this.criticalCostFactor;
    }
    return false;
  }

  timeDeadlineCritical(order: Order): boolean {
    return this.today.getTime() > new Date(order.deliveryDate).getTime();

  }

  onActivityReports(event: [string, ActivityReport[]]) {
    let order: Order | undefined = this.getOrderById(event[0]);
    if (order) {
      order.currentHours = event[1].reduce((total, activityReport) => total + activityReport.duration, 0);
    }
  }

  calculateBudget(order: Order) {
    if (order.currentHours && order.fixedPriceCostReport) {
      return order.fixedPriceCostReport;
    }
    if (order.currentHours && order.perHourCostReport) {
      return order.plannedHourlyBudget * order.currentHours;
    }
    return undefined;
  }
}