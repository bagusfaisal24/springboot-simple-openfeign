package openfeign.demo.io_github_openfeign.ouath2;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import lombok.Setter;
import openfeign.demo.io_github_openfeign.AbstractFormEncoder;
import openfeign.demo.io_github_openfeign.StashErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OauthClientSvc {
	
	@Value("${app.credentials.grant_type}")
	@Setter
	private String grantType;

	@Value("${app.credentials.client_id}")
	@Setter
	private String clientId;
	
	@Value("${app.credentials.client_secret}")
	@Setter
	private String clientSecret;
	
	@Value("${app.uri_backend}")
	@Setter
	private String uri;
	
	public CredentialToken getAuthenticatedUser(String username, String password) {
		BasicAuthRequestInterceptor interceptor = new BasicAuthRequestInterceptor(clientId,
				clientSecret);
		Oauth2Client credential = Feign.builder()
				.encoder(new AbstractFormEncoder(new GsonEncoder()))
				.decoder(new GsonDecoder())
				.errorDecoder(new StashErrorDecoder())
				.requestInterceptor(interceptor)
				.target(Oauth2Client.class, uri);
		return credential.getToken(grantType, username, password);
	}
}

