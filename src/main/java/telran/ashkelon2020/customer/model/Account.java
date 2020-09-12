package telran.ashkelon2020.customer.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"nickName"})
@Entity
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2109102350982321200L;
	@Id
	@Column(name = "NICK_NAME")
	String nickName;
	@Column(name = "LOGIN")
	String login;
	@Column(name = "PASSWORD")
	String password;
	@OneToMany(cascade = CascadeType.ALL)
	Set<Subscriber> subscribers;
	@ManyToOne
	//@JoinColumn(name = "customer_id")
	Customer customer;
	public Account(String nickName, String login, String password, Set<Subscriber> subscribers) {
		this.nickName = nickName;
		this.login = login;
		this.password = password;
		this.subscribers = subscribers;
	}
	
	
	
}
