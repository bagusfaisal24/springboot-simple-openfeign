package openfeign.demo.io_github_openfeign.ouath2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/oauth/token")
public class OauthController {
	
	private final OauthClientSvc oauthClientSvc;
	
	@Autowired
	public OauthController(OauthClientSvc oauthClientSvc) {
		this.oauthClientSvc = oauthClientSvc;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public CredentialToken getToken(@RequestParam(value = "username") String username,
									@RequestParam(value = "password") String password) {
		return oauthClientSvc.getAuthenticatedUser(username, password);
	}
}
