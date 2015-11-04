package entities;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;
import javax.validation.constraints.Null;
import javax.ws.rs.DefaultValue;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity

public class Task implements Serializable {

	
	private Integer id;
	private String name;
	private boolean done;
	private static final long serialVersionUID = 1L;
	
	private Project project;
	private User user;

	public Task() {
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
	@ManyToOne(cascade = CascadeType.MERGE)
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@ManyToOne
	@JoinColumn(name="userId",referencedColumnName="id", updatable = true, insertable = true)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@DefaultValue("0")
	public boolean getDone(){
		return done;
	}
	
	public void setDone(boolean done){
		this.done = done;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
   
}
