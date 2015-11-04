package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client implements Serializable {

	
	private Integer id;
	private String name;
	private static final long serialVersionUID = 1L;

	private List<Project> Projects;
	
	public Client() {
		super();
	} 
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@OneToMany(mappedBy = "client")
	public List<Project> getProjects() {
		return Projects;
	}
	public void setProjects(List<Project> projects) {
		Projects = projects;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", Projects=" + Projects
				+ "]";
	}
	
	
   
}
