package telran.ashkelon2020.customer.dto;

import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import telran.ashkelon2020.customer.model.Subscriber;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
	String nickName;
	String login;
	String password;
	Set<Subscriber> subscribers;
}
