package telran.ashkelon2020.customer.dto;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberDto {
	String name;
	String city;
}
