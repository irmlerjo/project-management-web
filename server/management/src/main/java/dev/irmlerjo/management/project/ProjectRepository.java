package dev.irmlerjo.management.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ProjectRepository {

	List<Project> projects = new ArrayList<>();

	List<Project> findAll() {
		return projects;
	}

	@PostConstruct
	private void init() {
		projects.add(new Project("1", "Duva NWS"));
		projects.add(new Project("2", "Expertensystem"));
		projects.add(new Project("3", "GIS System"));

	}
}
