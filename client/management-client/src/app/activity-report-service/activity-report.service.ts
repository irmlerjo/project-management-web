import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ActivityReport } from '../model/activityreport';

@Injectable({
  providedIn: 'root'
})
export class ActivityReportService {

  private apiUrl = '/api/activityreports'; // API endpoint for orders

  constructor(private http: HttpClient) { }

  getActivityReportsByOrderId(orderId: string): Observable<ActivityReport[]> {
    return this.http.get<ActivityReport[]>(`${this.apiUrl}/${orderId}`);
  }

  getDocumentedHoursByOrderId(orderId: string): Observable<ActivityReport[]> {
    return this.http.get<ActivityReport[]>(`${this.apiUrl}/${orderId}`);
  }
}