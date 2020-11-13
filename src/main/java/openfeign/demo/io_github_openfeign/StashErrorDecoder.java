package openfeign.demo.io_github_openfeign;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

import java.io.IOException;


public class StashErrorDecoder implements ErrorDecoder {
	
	private final ErrorDecoder defaultErrorDecoder = new Default();
	
	@Override
	public Exception decode(String methodKey, Response response) {
		if (response.status() >= 400 && response.status() <= 499) {
			try {
				byte[] bodyData = Util.toByteArray(response.body().asInputStream());
				String responseBody = new String(bodyData);
				return new MessageError(responseBody);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (response.status() >= 500 && response.status() < 599) {
			try {
				byte[] bodyData = Util.toByteArray(response.body().asInputStream());
				String responseBody = new String(bodyData);
				return new MessageError(responseBody);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return defaultErrorDecoder.decode(methodKey, response);
	}
}
