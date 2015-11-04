package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
public class User implements Serializable {

	private Integer id;
	private String name;
	private String login;
	private String password;
	
	private static final long serialVersionUID = 1L;
	
	private List <Task> tasks;
	private Team team;


	public User() {
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy = "user")
	public List <Task> getTasks() {
		return tasks;
	}

	public void setTasks(List <Task> tasks) {
		this.tasks = tasks;
	}
	@ManyToOne
	@JoinColumn(name="teamId",referencedColumnName="id", updatable = true, insertable = true)
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	

	public User(Integer id, String name, String login, String password,
			 List<Task> tasks, Team team) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.tasks = tasks;
		this.team = team;
	}
	
}