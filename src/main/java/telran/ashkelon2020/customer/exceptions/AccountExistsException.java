package telran.ashkelon2020.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AccountExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4257981610163225020L;
	public AccountExistsException() {
		super("account exists");
	}
}
