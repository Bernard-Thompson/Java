package com.bam.task.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;







@Entity
public class Adventurer {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String rank;
	private int experiencePoints;
	
	
	@OneToMany(mappedBy = "adventurer")
	private List<Quest> quests;

}
