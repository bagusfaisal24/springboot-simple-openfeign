package openfeign.demo.io_github_openfeign.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/v1/me")
public class UserController {
	
	private final UserSvc userSvc;
	
	@Autowired
	public UserController(UserSvc userSvc) {
		this.userSvc = userSvc;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	UserPojo getMe(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		return userSvc.getMe(token);
	}
}
