package com.quick.pickup.except;

public class GroupeNotFoundException extends RuntimeException {
	
	private String msg ;
	
	public GroupeNotFoundException(String msg) {
		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		return this.msg;
	}
}
