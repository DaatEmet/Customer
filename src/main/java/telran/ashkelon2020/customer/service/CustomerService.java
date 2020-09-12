package telran.ashkelon2020.customer.service;

import java.util.List;

import telran.ashkelon2020.customer.dto.AccountDto;
import telran.ashkelon2020.customer.dto.CustomerDto;
import telran.ashkelon2020.customer.dto.SubscriberDto;

public interface CustomerService {
	boolean addCustomer(CustomerDto customerDto);
	boolean addAccount(AccountDto accountDto, String customerId);
	boolean AddSubscriber(SubscriberDto subscriberDto,String NickName);
	CustomerDto findCustomer(String id);
	AccountDto findAccount(String nickName);
	SubscriberDto findSubscride(String name);
	CustomerDto updateCustomer(String id, String name, String lastName);
	AccountDto updateAccount(String nickName, String login, String password);
	SubscriberDto updateSubscride(String name, String newName, String city);
	CustomerDto deleteCustomer(String id);
	AccountDto deleteAccount(String nickName);
	SubscriberDto deleteSubscride(String name);
	AccountDto findCustomersAccount(String accountNickName);
}
