package UnidirectionalOne2ManyList;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Passenger {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Flight> flightList = new ArrayList<>();

	public Passenger(String name) {
		this.name = name;
	}

	public void addFlight(Flight flight) {
		flightList.add(flight);
	}

}
