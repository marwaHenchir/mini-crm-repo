package entities;

import entities.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Technicien
 *
 */
@Entity

public class Technicien extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Technicien() {
		super();
	}
   
}
