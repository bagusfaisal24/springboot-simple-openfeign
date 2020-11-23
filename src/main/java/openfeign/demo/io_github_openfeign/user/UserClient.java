package openfeign.demo.io_github_openfeign.user;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface UserClient {
	
	@RequestLine("GET /v1/user/me")
	@Headers("Authorization: {access_token}")
	UserPojo getMe(@Param("access_token") String access_token);

	@RequestLine("GET /v1/user")
	@Headers("Authorization: {access_token}")
	List<UserPojo> getAllUser(@Param("access_token") String access_token);
}
