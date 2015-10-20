package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tech
 *
 */
@Entity

public class Tech extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Tech() {
		super();
	}
   
}
