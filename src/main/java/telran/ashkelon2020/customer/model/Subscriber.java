package telran.ashkelon2020.customer.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "name" })
@Entity
public class Subscriber implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9087542642270875566L;
	@Id
	@Column(name = "NAME")
	String name;
	@Column(name = "CITY")
	String city;
	@ManyToOne(cascade = CascadeType.ALL)
	Account account;
	public Subscriber(String name, String city) {
		this.name = name;
		this.city = city;
	}
	
	
}
