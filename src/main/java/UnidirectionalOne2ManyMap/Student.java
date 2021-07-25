package UnidirectionalOne2ManyMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Student {

	@Id
	private int studentId;

	private String firstName;
	private String lastName;

	public Student(int studentId, String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
	}

}
