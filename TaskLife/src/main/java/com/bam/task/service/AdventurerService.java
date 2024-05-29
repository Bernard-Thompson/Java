package com.bam.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bam.task.model.Adventurer;
import com.bam.task.repository.AdventurerRepository;

@Service
public class AdventurerService {
	
	
	
	@Autowired
	private AdventurerRepository adventurerRepository;
	
	public List<Adventurer> getAllAdventurers(){
		return adventurerRepository.findAll();
	}
	
	public Optional<Adventurer> getAdventurerById(Long id){
		return adventurerRepository.findById(id);
	}
	
	
	public Adventurer createAdventurer(Adventurer adventurer) {
		return adventurerRepository.save(adventurer);
	}

}
