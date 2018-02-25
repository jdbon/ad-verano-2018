package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MovimientoAB")
public class MovimientoABEntity extends MovimientoEntity {

	public MovimientoABEntity() {
		
	}
}

