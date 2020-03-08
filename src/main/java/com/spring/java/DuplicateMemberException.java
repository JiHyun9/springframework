package com.spring.java;

//email 중복인 경우 
public class DuplicateMemberException extends RuntimeException{
	public DuplicateMemberException(String message) {
		super(message);
	}

}
