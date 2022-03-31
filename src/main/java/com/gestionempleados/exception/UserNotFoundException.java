package com.gestionempleados.exception;

public class UserNotFoundException extends Exception {
	
	private int ID;
	private String msg;
	private static final long serialVersionUID = -6295707110420329231L;

	public UserNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserNotFoundException(int ID) {
		super();
		this.ID=ID;
		this.msg="UserNotFoundException: Usuario con la ID = "+ID+" no existe en la base de datos.";
	}
	
	public UserNotFoundException(String msg) {
		super();
		this.msg=msg;
	}

	@Override
	public String toString() {
		return msg;
	}
	
}
