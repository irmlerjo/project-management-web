import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectService } from '../project-service/project.service';
import { Project } from '../model/project';
import { NgFor, NgIf } from '@angular/common';
import { OrderComponent } from "../order/order.component";

import { MatCardModule } from '@angular/material/card';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatAccordion, MatExpansionModule } from '@angular/material/expansion';

@Component({
  selector: 'app-project',
  imports: [NgIf, NgFor, OrderComponent, MatCardModule, MatListModule, MatIconModule, MatButtonModule, MatAccordion, MatExpansionModule],
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css'],
})
export class ProjectComponent implements OnInit {
  projects: Project[] = [];
  selectedProject: Project | null = null;

  constructor(
    private projectService: ProjectService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadProjects();
  }

  loadProjects(): void {
    this.projectService.getProjects().subscribe({
      next: (data) => {
        this.projects = data;
      },
      error: (error) => {
        console.error('Error fetching projects', error);
      },
    });
  }

  onProjectClick(project: Project): void {
    this.selectedProject = project;
    //this.router.navigate(['/orders', project.id]);
  }
  onNewProject(): void {
    this.router.navigate(['/create']);
  }
}