package openfeign.demo.io_github_openfeign.user;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface UserClient {
	
	@RequestLine("GET /v1/user/me")
	@Headers("Authorization: {access_token}")
	UserPojo getMe(@Param("access_token") String access_token);
}
