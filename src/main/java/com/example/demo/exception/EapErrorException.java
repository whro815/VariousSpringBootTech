package com.example.demo.exception;

import lombok.Getter;

@Getter
public class EapErrorException extends RuntimeException {
	
	private static final long serialVersionUID = 955836850813129748L;
	
	private int code;
	private String message;

	public EapErrorException(int code) {
		this.code = code;
	}
	
	public EapErrorException(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
