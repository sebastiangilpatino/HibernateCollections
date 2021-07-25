package UnidirectionalOne2ManyMap;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
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
public class School {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	@OneToMany(cascade = CascadeType.PERSIST)
	@MapKey(name = "studentId")
	private Map<Integer, Student> studentMap = new HashMap<>();

	public School(String name) {
		this.name = name;
	}

	public void addStudent(Student student) {
		studentMap.put(student.getStudentId(), student);
	}

}
