package openfeign.demo.io_github_openfeign.user;

import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserSvc {
	
	@Value("${app.uri_backend}")
	@Setter
	private String uri;
	
	UserPojo getMe(String access_token){
		UserClient userClient = Feign.builder()
				.decoder(new GsonDecoder())
				.target(UserClient.class, uri);
		return userClient.getMe(access_token);
	}
}
