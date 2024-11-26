package com.bam.task.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Optional;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



@Data
@Entity
@Table(name = "quests")
public class Quest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
     * The name of the quest.
     * Cannot be null or blank to ensure valid input.
     */
	@NotBlank(message = "Quest name cannot be blank.")
	@Column(nullable = false, length = 100)
	private String name;
	
	/**
     * A detailed description of the quest.
     * Optional, but capped at 500 characters for database efficiency.
     */
	@Column(length = 500)
	private String description;
	
	
	/**
     * The current status of the quest.
     * Managed as an enumerated type for clarity and validation.
     */
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Quest status cannot be null.")
	@Column(nullable = false)
	private Status status;
	
	
	/**
     * The time-stamp when the quest was created.
     * Automatically managed by the application to track creation time.
     */
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdDate;
	
	
	
	/**
     * The timestamp when the quest was last updated.
     * Automatically managed to track updates.
     */
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime lastUpdatedDate;
	
	
	
	
	
	/**
     * The time-stamp when the quest was completed.
     * This will be null until the quest is marked as COMPLETED.
     */
	private LocalDateTime completedDate;
	
	
	/**
     * The adventurer assigned to this quest, if any.
     * An optional association represented as a Many-to-One relationship.
     * Uses @ToString.Exclude and @EqualsAndHashCode.Exclude to prevent circular references during logging or equality checks.
     */
	@ManyToOne(fetch = FetchType.LAZY) //Lazy loading to optimize performance
	@JoinColumn(name = "adventuer_id", nullable = true)
	@JsonIgnore //Prevent circular reference in serialization
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Adventurer adventurer;
	
	
	
	/**
     * The client who requested the quest.
     * This is a mandatory association represented as a Many-to-One relationship.
     */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	@JsonIgnore
	@NotNull(message = "client cannot be null.")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Client client;
	
	
	/**
     * Gets the client associated with this quest.
     * @return The client object.
     */
    public Client getClient() {
        return this.client;
    }

    /**
     * Gets the unique ID of the quest.
     * @return The ID of the quest.
     */
    public Long getId() {
        return this.id;
    }
	
	
	
	
	
	/**
     * Sets the client for this quest.
     * @param client the client to associate with this quest.
     */
    public void setClient(Client client) {
        this.client = client;
    }
	
	
	
	
	
	/**
     * Enum to represent possible statuses of a quest.
     * Helps enforce valid states and simplifies validation logic.
     */
    public enum Status {
        NEW("Newly created quest."), 
        IN_PROGRESS("Quest is currently underway."), 
        COMPLETED("Quest has been completed."), 
        CANCELLED("Quest has been cancelled.");
    	
    	private final String description;
    	
    	Status(String description){
    		this.description = description;
    	}
    	
    	/**
         * Returns a human-readable description of the status.
         */
        public String getDescription() {
            return description;
        }
    }
	
	
	
	
    /**
     * Default constructor initializes status and creation timestamp.
     */
    public Quest() {
        this.status = Status.NEW;
    }
	
	
	
	
	
	
    /**
     * Sets the completed date to the current time-stamp.
     * Should only be called when the quest is completed.
     */
    public void markAsCompleted() {
    	if (this.status == Status.COMPLETED) {
    		throw new IllegalStateException("Quest is already completed.");
    	}
        this.completedDate = LocalDateTime.now();
        this.status = Status.COMPLETED;
    }
	
	
	
    /**
     * Updates the status of the quest with validation to prevent invalid transitions.
     * @param newStatus The new status to set.
     */
    public void updateStatus(Status newStatus) {
        if (this.status == Status.COMPLETED) {
            throw new IllegalStateException("Cannot update a completed quest.");
        }
        this.status = newStatus;
    }
	
	
	
	
	
    /**
     * Returns an optional completed date to handle nullable fields safely.
     *
     * @return An Optional containing the completed date if present.
     */
    public Optional<LocalDateTime> getCompletedDate() {
        return Optional.ofNullable(completedDate);
    }
	
	

}
