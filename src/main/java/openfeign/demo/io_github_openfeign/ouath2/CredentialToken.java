package openfeign.demo.io_github_openfeign.ouath2;

import lombok.Data;

@Data
public class CredentialToken {
	
	public String access_token;
	public String token_type;
}
