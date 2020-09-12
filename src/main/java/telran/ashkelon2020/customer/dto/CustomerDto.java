package telran.ashkelon2020.customer.dto;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import telran.ashkelon2020.customer.model.Account;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	String id;
	String name;
	String lastName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate birthDate;
	Set<Account> accounts;
}
