package BidirectionalOne2Many;

import java.util.HashSet;
import java.util.Set;

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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {
	@Id
	@GeneratedValue
	private int id;

	private String firstName;
	private String lastName;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST)
	Set<Laptop> laptops = new HashSet<>();

	public void addLaptop(Laptop laptop) {
		laptop.setEmployee(this);
		laptops.add(laptop);
	}

	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
