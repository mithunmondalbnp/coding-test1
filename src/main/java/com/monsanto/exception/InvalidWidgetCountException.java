package com.monsanto.exception;

public class InvalidWidgetCountException extends BaseExceptions{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidWidgetCountException(String msg) {
		super(msg);
	}

	public InvalidWidgetCountException(Throwable e) {
		super(e);
	}

	public InvalidWidgetCountException(String msg, Throwable e) {
		super(msg,e);
	}

	public InvalidWidgetCountException() {
		super();
	}
}
