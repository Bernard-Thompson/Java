package com.bam.task.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@Entity
public class Client {
	
	
	private static final Logger logger = LoggerFactory.getLogger(Client.class);
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	/**
     * The name of the client.
     * Cannot be null or blank and is capped at 100 characters for database efficiency.
     */
    @NotBlank(message = "Client name cannot be blank.")
    @Size(max = 100, message = "Client name cannot exceed 100 characters.")
    @Column(nullable = false, length = 100)
	private String name;
    
    /**
     * The client's tier (e.g., Bronze, Silver, Gold).
     * Optional but capped at 50 characters for clarity.
     */
    @Size(max = 50, message = "Client tier cannot exceed 50 characters.")
    @Column(length = 50)
	private String tier;
    
    /**
     * The client's email address.
     * Validates the format and ensures it is unique in the database.
     */
    @NotBlank(message = "Client email cannot be blank.")
    @Email(message = "Invalid email format.")
    @Column(nullable = false, unique = true, length = 100)
	private String email;

    /**
     * A list of quests associated with the client.
     * Managed as a One-to-Many relationship with Quest.
     * Cascade operations are defined to ensure consistency when modifying client data.
     */
	@OneToMany(
			mappedBy = "client",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.LAZY
			)
	@ToString.Exclude //Avoid circular reference in toString()
	@EqualsAndHashCode.Exclude // Avoid circular reference in equals/hashCode
	private List<Quest> quests = new ArrayList<>();
	
	
	
	
	/**
     * Associates a quest with the client.
     * Ensures proper bidirectional association.
     * 
     * @param quest The quest to associate with this client.
     * @throws IlleagalArgumentException if the quest is null or already associated with another client.
     */
    public void addQuest(Quest quest) {
    	if (quest == null) {
            logger.error("Attempted to add a null quest to client with ID: {}", id);
            throw new IllegalArgumentException("Quest cannot be null.");
        }
        if (quest.getClient() != null && !quest.getClient().equals(this)) {
            logger.error("Quest with ID {} is already associated with another client.", quest.getId());
            throw new IllegalArgumentException("Quest is already assigned to a different client.");
        }
        quests.add(quest);
        quest.setClient(this);
        logger.info("Quest with ID {} added to client with ID: {}", quest.getId(), id);
    }
	
	
    /**
     * Removes a quest from the client.
     * Ensures proper bidirectional association is removed.
     * 
     * @param quest The quest to dis-associate from this client.
     * @throws IlleagalArgumentException if the quest is null or not associated with this client.
     */
    public void removeQuest(Quest quest) {
    	if (quest == null || !quests.contains(quest)) {
            logger.error("Attempted to remove a quest that does not belong to client with ID: {}", id);
            throw new IllegalArgumentException("Quest is not associated with this client.");
        }
        quests.remove(quest);
        quest.setClient(null);
        logger.info("Quest with ID {} removed from client with ID: {}", quest.getId(), id);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}






























