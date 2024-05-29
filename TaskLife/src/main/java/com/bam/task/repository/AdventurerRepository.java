package com.bam.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bam.task.model.Adventurer;

public interface AdventurerRepository extends JpaRepository<Adventurer, Long>{

}
