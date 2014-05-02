package org.springframework.ldap.samples.useradmin.util;

public class MemberNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1886433452227376718L;

	public MemberNotFoundException() {
		super();
	}
	
	public MemberNotFoundException(String message) {
		super(message);
	}
	
	public MemberNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public MemberNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
