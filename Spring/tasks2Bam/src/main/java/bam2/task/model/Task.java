package bam2.task.model;





import jakarta.persistence.*;


@Entity
@Table(name = "tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "time")
	private int time;
	
	@Column(name = "published")
	private boolean published;
	
	@Column(name = "completed")
	private boolean completed;
	
	
	public Task() {
		
	}

}
