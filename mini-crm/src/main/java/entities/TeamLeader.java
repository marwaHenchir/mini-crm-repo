package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TeamLeader
 *
 */
@Entity

public class TeamLeader extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private TeamLeader teamLeader;

	public TeamLeader() {
		super();
	}
	
	@OneToOne
	public TeamLeader getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(TeamLeader teamLeader) {
		this.teamLeader = teamLeader;
	}
   
}
