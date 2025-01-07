package dev.irmlerjo.management.project;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	private final ProjectRepository projectRepository;

	public ProjectController(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@GetMapping("")
	public List<Project> findAll() {
		System.err.println("Reached");
		return projectRepository.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public String createProject(@RequestBody Project project) {
		return projectRepository.create(project);
	}
	
	@GetMapping("/{id}")
	public Optional<Project> getProjectById(@PathVariable String id) {
		return projectRepository.findById(id);
	}
	
	@PutMapping("/{id}")
	public void updateProjectById(@PathVariable String id,@RequestBody Project project) {
		 projectRepository.update(id,project);
	}

}
