package BidirectionalOne2Many;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Laptop {

	@Id
	@GeneratedValue
	private int id;
	private String brand;
	private String type;

	@ManyToOne
	@ToString.Exclude
	private Employee employee;

	public Laptop(String brand, String type) {
		this.brand = brand;
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, employee, id, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Laptop other = (Laptop) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(employee, other.employee) && id == other.id
				&& Objects.equals(type, other.type);
	}

}
