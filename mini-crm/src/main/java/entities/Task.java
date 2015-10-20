package entities;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity

public class Task implements Serializable {

	
	private Integer id;
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
	@ManyToOne
	@JoinColumn(name="taskId",referencedColumnName="id", updatable = false, insertable = false)
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@ManyToOne
	@JoinColumn(name="userId",referencedColumnName="id", updatable = false, insertable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
   
}
