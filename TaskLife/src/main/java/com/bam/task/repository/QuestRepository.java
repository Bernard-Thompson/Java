package com.bam.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bam.task.model.Quest;

public interface QuestRepository extends JpaRepository <Quest, Long>{
	
	

}
