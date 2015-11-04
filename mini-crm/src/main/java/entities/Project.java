package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity

public class Project implements Serializable {

	
	private Integer id;
	private String name;
	
	private static final long serialVersionUID = 1L;
	
	private Client client;
	private List<Task> tasks;

	public Project() {
		super();
	}
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	@JoinColumn(name="clientId",referencedColumnName="id", updatable = false, insertable = true)
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@OneToMany(mappedBy = "project")
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", client=" + client
				+ ", tasks=" + tasks + "]";
	}
	
}
