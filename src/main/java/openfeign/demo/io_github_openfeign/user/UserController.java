package openfeign.demo.io_github_openfeign.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {
	
	private final UserSvc userSvc;
	
	@Autowired
	public UserController(UserSvc userSvc) {
		this.userSvc = userSvc;
	}

	@RequestMapping(method = RequestMethod.GET)
	List<UserPojo> getAll(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		userSvc.newArrData(token);
		return userSvc.getAll();
	}

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	UserPojo getMe(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		return userSvc.getMe(token);
	}


}
