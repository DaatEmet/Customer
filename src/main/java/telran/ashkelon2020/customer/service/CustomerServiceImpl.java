package telran.ashkelon2020.customer.service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import telran.ashkelon2020.customer.dao.AccountRepository;
import telran.ashkelon2020.customer.dao.CustomerRepository;
import telran.ashkelon2020.customer.dao.SubscriberRepository;
import telran.ashkelon2020.customer.dto.AccountDto;
import telran.ashkelon2020.customer.dto.CustomerDto;
import telran.ashkelon2020.customer.dto.SubscriberDto;
import telran.ashkelon2020.customer.exceptions.AccountExistsException;
import telran.ashkelon2020.customer.exceptions.EntityNotFounDException;
import telran.ashkelon2020.customer.model.Account;
import telran.ashkelon2020.customer.model.Customer;
import telran.ashkelon2020.customer.model.Subscriber;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	SubscriberRepository subscriberRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public boolean addCustomer(CustomerDto customerDto) {
		if (customerRepository.existsById(customerDto.getId())) {
			return false;
		}
		Customer customer = modelMapper.map(customerDto, Customer.class);
		customerRepository.save(customer);
		return true;
	}

	@Override
	public boolean addAccount(AccountDto accountDto, String customerId) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFounDException());
		if (accountRepository.existsById(accountDto.getNickName())) {
			throw new AccountExistsException();
		}
		Account account = new Account(accountDto.getNickName(), accountDto.getLogin(),
				accountDto.getPassword(), new HashSet<>());
		accountRepository.save(account);
		customer.getAccounts().add(account);
		customerRepository.save(customer);
		return true;
	}

	@Override
	public boolean AddSubscriber(SubscriberDto subscriberDto, String nickName) {
		Account account = accountRepository.findById(nickName).orElseThrow(()-> new EntityNotFounDException());
		if (subscriberRepository.existsById(subscriberDto.getName())) {
			return false;
		}
		Subscriber subscriber = new Subscriber(subscriberDto.getName(), subscriberDto.getCity());
		subscriberRepository.save(subscriber);
		account.getSubscribers().add(subscriber);
		accountRepository.save(account);
		return true;
	}

	@Override
	public CustomerDto findCustomer(String id) {
		Customer customer = customerRepository.findById(id).orElseThrow(()-> new EntityNotFounDException());
		return modelMapper.map(customer, CustomerDto.class);
	}

	@Override
	public AccountDto findAccount(String nickName) {
		Account account = accountRepository.findById(nickName).orElseThrow(()-> new EntityNotFounDException());
		return modelMapper.map(account, AccountDto.class);
	}

	@Override
	public SubscriberDto findSubscride(String name) {
		Subscriber subscriber = subscriberRepository.findById(name).orElseThrow(()-> new EntityNotFounDException());
		return modelMapper.map(subscriber, SubscriberDto.class);
	}
	
	@Transactional
	@Override
	public CustomerDto updateCustomer(String id, String name, String lastName) {
		Customer customer = customerRepository.findById(id).orElseThrow(()-> new EntityNotFounDException());
		if(name != null) {
			customer.setName(name);
		}
		if(lastName != null) {
			customer.setLastName(lastName);
		}
		customerRepository.save(customer);
		return modelMapper.map(customer, CustomerDto.class);
	}
	@Transactional
	@Override
	public AccountDto updateAccount(String nickName, String login, String password) {
		Account account = accountRepository.findById(nickName).orElseThrow(()-> new EntityNotFounDException());
		if(login != null) {
			account.setLogin(login);
		}
		if(password != null) {
			account.setPassword(password);
		}
		accountRepository.save(account);
		return modelMapper.map(account, AccountDto.class);
	}
	@Transactional
	@Override
	public SubscriberDto updateSubscride(String name, String newName, String city) {
		Subscriber subscriber = subscriberRepository.findById(name).orElseThrow(()-> new EntityNotFounDException());
		if(newName != null) {
			subscriber.setName(newName);
		}
		if(city != null) {
			subscriber.setCity(city);
		}
		subscriberRepository.save(subscriber);
		return modelMapper.map(subscriber, SubscriberDto.class);
	}
	@Transactional
	@Override
	public CustomerDto deleteCustomer(String id) {
		Customer customer = customerRepository.findById(id).orElseThrow(()-> new EntityNotFounDException());
		customerRepository.delete(customer);
		return modelMapper.map(customer, CustomerDto.class);
	}
	@Transactional
	@Override
	public AccountDto deleteAccount(String nickName) {
		Account account = accountRepository.findById(nickName).orElseThrow(()-> new EntityNotFounDException());
		accountRepository.delete(account);
		return modelMapper.map(account, AccountDto.class);
	}
	@Transactional
	@Override
	public SubscriberDto deleteSubscride(String name) {
		Subscriber subscriber = subscriberRepository.findById(name).orElseThrow(()-> new EntityNotFounDException());
		subscriberRepository.delete(subscriber);
		return modelMapper.map(subscriber, SubscriberDto.class);
	}
	
	@Transactional
	@Override
	public AccountDto findCustomersAccount(String Login) {
		Account account = customerRepository.findByAccountsLogin(Login);
		return modelMapper.map(account, AccountDto.class);
	}
	
}
