package com.bam.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bam.task.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
