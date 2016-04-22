package es.uniovi.asw.dbupdate.exception;

/**
 * This a non checked exception. It indicates technical issues in the 
 * persistence layer or other types of non-functional problems.
 *  
 */
public class PersistenceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PersistenceException() {
		super();
	}

	public PersistenceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public PersistenceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PersistenceException(String arg0) {
		super(arg0);
	}

	public PersistenceException(Throwable arg0) {
		super(arg0);
	}

}
