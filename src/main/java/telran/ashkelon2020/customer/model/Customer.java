package telran.ashkelon2020.customer.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	String id;
	@Column(name = "Name")
	String name;
	@Column(name = "LAST_NAME")
	String lastName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate birthDate;
	@JoinTable(
			name = "CUSTOMER_ACCOUNTS",
			joinColumns = @JoinColumn(name= "CUSTOMER_ID"),
			inverseJoinColumns = @JoinColumn(name = "ACCOUNTS_NICK_NAME")
			)
	@OneToMany(cascade = CascadeType.ALL)
	Set<Account> accounts;	
}
