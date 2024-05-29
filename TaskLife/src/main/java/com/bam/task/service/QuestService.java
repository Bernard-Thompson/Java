package com.bam.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.bam.task.model.Client;
import com.bam.task.model.Quest;
import com.bam.task.repository.QuestRepository;

@Service
public class QuestService {
	
	@Autowired
	private QuestRepository questRepository;
	
	public List<Quest> getAllQuests(){
		return questRepository.findAll();
	}
	
	
	public Optional<Quest> getQuestById(Long id) {
		return questRepository.findById(id);
	}
	
	
	public Quest createQuest(Quest quest) {
		return questRepository.save(quest);
	}
	
	
	@Async
	public void sendConfirmationEmail(Client client, Quest quest) {
		
	}

}
