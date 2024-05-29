package com.bam.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bam.task.model.Client;
import com.bam.task.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}
	
	
	public Optional<Client> getClientById(Long id){
		return clientRepository.findById(id);
	}
	
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}

}
