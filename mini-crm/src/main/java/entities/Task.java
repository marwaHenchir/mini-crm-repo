package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.security.Timestamp;
import java.util.Date;

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
	private Date start_date;
	private Date  finish_date;
	private int duration ;
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
	
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getFinish_date() {
		return finish_date;
	}
	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
   
}
