package telran.ashkelon2020.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2020.customer.dto.AccountDto;
import telran.ashkelon2020.customer.dto.CustomerDto;
import telran.ashkelon2020.customer.dto.SubscriberDto;
import telran.ashkelon2020.customer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService service;

	@PostMapping("/customer")
	boolean addCustomer(@RequestBody CustomerDto customerDto) {
		return service.addCustomer(customerDto);
	}
	
	@PostMapping("/account/{id}")
	boolean addAccount(@RequestBody AccountDto accountDto, @PathVariable String id) {
		return service.addAccount(accountDto, id);
	}
	
	@PostMapping("/subscriber/{nickName}")
	boolean SubscriberDto(@RequestBody SubscriberDto subscriberDto, @PathVariable String nickName) {
		return service.AddSubscriber(subscriberDto, nickName);
	}
	
	@GetMapping("/customer/{id}")
	CustomerDto getCustomer(@PathVariable String id) {
		return service.findCustomer(id);
	}
	
	@GetMapping("/account/{name}")
	AccountDto getAccount(@PathVariable String name) {
		return service.findAccount(name);
	}
	
	@GetMapping("/subscriber/{name}")
	SubscriberDto getSubscribe(@PathVariable String name) {
		return service.findSubscride(name);
	}
	
	
	@PutMapping("/customer/{id}")
	CustomerDto updateCustomer(@PathVariable String id,@RequestParam String name,@RequestParam String lastName) {
		return service.updateCustomer(id, name, lastName);
	}
	

	@PutMapping("/account/{nickName}")
	AccountDto updateAccount(@PathVariable String nickName, @RequestHeader("Login") String login, @RequestHeader("Password") String password) {
		return service.updateAccount(nickName, login, password);
	}
	
	
	@PutMapping("/subscriber/{name}")
	SubscriberDto updateSubscribe(@PathVariable String name,@RequestParam String newName,@RequestParam String city) {
		return service.updateSubscride(name, newName, city);
	}
	
	
	@DeleteMapping("/customer/{id}")
	CustomerDto deleteCustomer(@PathVariable String id) {
		return service.deleteCustomer(id);
	}
	
	
	@DeleteMapping("/account/{nickName}")
	AccountDto deleteAccount(@PathVariable String nickName) {
		return service.deleteAccount(nickName);
	}
	
	
	@DeleteMapping("/subscriber/{name}")
	SubscriberDto deleteSubscriber(@PathVariable String name) {
		return service.deleteSubscride(name);
	}
	
	@GetMapping("/account/login/{login}")
	AccountDto findByLogin(@PathVariable String login) {
		return service.findCustomersAccount(login);
	}

}
