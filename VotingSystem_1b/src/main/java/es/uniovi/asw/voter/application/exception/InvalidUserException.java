package es.uniovi.asw.voter.application.exception;

public class InvalidUserException  extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidUserException() {
	}

	public InvalidUserException(String string) {
		super(string);
	}

}

