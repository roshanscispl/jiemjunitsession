package jiem;

public class InsufficientBalanceException extends Exception {
String msg;
	InsufficientBalanceException(String msg){
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return this.msg;
	}
	
	
	
}
