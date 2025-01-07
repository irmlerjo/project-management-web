package dev.irmlerjo.management.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ProjectRepository {

	List<Project> projects = new ArrayList<>();

	List<Project> findAll() {
		return this.projects;
	}

	@PostConstruct
	private void init() {
		this.projects.add(new Project("1", "Duva NWS"));
		this.projects.add(new Project("2", "Expertensystem"));
		this.projects.add(new Project("3", "GIS System"));
	}

	public Optional<Project> findById(String id) {
		return this.projects.stream().filter(project -> project.id().equals(id)).findFirst();
	}

	public void update(String id,Project updatedProject) {
		Optional<Project> currentProject = findById(id);
		if (currentProject.isPresent()) {
			this.projects.set(this.projects.indexOf(currentProject.get()), updatedProject);
		}
	}

	public String create(Project project) {
		String newId=this.generateId();
		this.projects.add(new Project(newId,project.name()));
		return newId;		
	}

	// Provisional. Does not check for collisions.
	private String generateId() {
		return Integer.toString(new Random().nextInt());
	}
}
