package com.bam.task.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Quest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	private String status;
	private LocalDateTime createdDate;
	private LocalDateTime completedDate;
	
	
	
	@ManyToOne
	private Adventurer adventurer;
	
	
	@ManyToOne
	private Client client;

}
