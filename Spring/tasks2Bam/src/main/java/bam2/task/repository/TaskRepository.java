package bam2.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bam2.task.model.Task;






public interface TaskRepository extends JpaRepository<Task, Long>{
	
	List<Task> findByPublished(boolean published);
	List<Task> findByNameContaining(String name);

}
