package openfeign.demo.io_github_openfeign.ouath2;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface Oauth2Client {
	
	@RequestLine("POST /oauth/token")
	@Headers("Content-Type: application/json")
	@Body("%7B\"grant_type\": \"password\",\"username\": \"{username}\", \"password\": \"{password}\"%7D")
	CredentialToken getToken(@Param("username") String username, @Param("password") String password);
}
