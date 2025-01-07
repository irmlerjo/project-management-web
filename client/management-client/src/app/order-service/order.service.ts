import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Order } from '../model/order';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  private apiUrl = '/api/projects'; // API endpoint for orders
  private ordersUrl = 'orders';

  constructor(private http: HttpClient) { }


  getOrdersByProjectId(projectId: string): Observable<Order[]> {
    return this.http.get<Order[]>(`${this.apiUrl}/${projectId}/${this.ordersUrl}`);
  }
}