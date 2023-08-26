package bam2.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bam2.task.model.Task;
import bam2.task.repository.TaskRepository;





@CrossOrigin(origins = "http://localhost:8084")
@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	TaskRepository taskRepository;
	
	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) String name){
		return null;
		
	}
	
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") long id){
		return null;
		
	}
	
	
	@PostMapping("/tasks")
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		return null;
		
	}
	
	
	@PutMapping("/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") long id, @RequestBody Task task){
		return null;
		
	}
	
	
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<HttpStatus> deleteTask(@PathVariable("id") long id){
		return null;
		
	}
	
	
	@DeleteMapping("/tasks")
	public ResponseEntity<HttpStatus> deleteAllTask(){
		return null;
		
	}
	
	@GetMapping("/tasks/published")
	public ResponseEntity<List<Task>> findByPublished(){
		return null;
		
	}
	
	
	
	
	
	
	
	
	

}
