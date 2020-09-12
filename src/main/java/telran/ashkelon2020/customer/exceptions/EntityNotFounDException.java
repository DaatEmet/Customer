package telran.ashkelon2020.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFounDException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
