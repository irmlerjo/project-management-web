import { Routes } from '@angular/router';
import { ProjectComponent } from './project/project.component';
import { CreateOrderComponent } from './create-order/create-order.component';

export const routes: Routes = [
    { path: '', component: ProjectComponent },
    { path: 'create', component: CreateOrderComponent }];