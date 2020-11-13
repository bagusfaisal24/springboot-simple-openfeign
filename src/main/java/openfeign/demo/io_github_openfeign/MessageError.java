package openfeign.demo.io_github_openfeign;


public class MessageError extends Exception {
	
	MessageError(String body) {
		super(body);
	}
}
