package UnidirectionalOne2ManyList;

import java.time.LocalDate;

import javax.persistence.Column;
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
public class Flight {

	@Id
	@GeneratedValue
	private int id;

	private int fligtNumber;

	@Column(name = "origin")
	private String from;

	@Column(name = "destination")
	private String to;

	private LocalDate date;

	public Flight(int fligtNumber, String from, String to, LocalDate date) {
		this.fligtNumber = fligtNumber;
		this.from = from;
		this.to = to;
		this.date = date;
	}

}
