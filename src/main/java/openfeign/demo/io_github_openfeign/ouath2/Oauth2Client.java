package openfeign.demo.io_github_openfeign.ouath2;

import feign.Param;
import feign.RequestLine;

public interface Oauth2Client {
	
	@RequestLine("POST /oauth/token?grant_type={grant_type}&username={username}&password={password}")
	CredentialToken getToken(@Param("grant_type") String grant_type, @Param("username") String username, @Param("password") String password);
}
