package openfeign.demo.basic.github_profiler;

import openfeign.demo.basic.profile_pojo.ProfileDataPojo;
import openfeign.demo.basic.rest_template.GithubProfileFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/profile")
public class GithubProfileController {
	
	private final GithubProfileFeign githubProfileFeign;
	
	@Autowired
	public GithubProfileController(GithubProfileFeign githubProfileFeign) {
		this.githubProfileFeign = githubProfileFeign;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ProfileDataPojo getData(){
		return githubProfileFeign.getDataProfile();
	}
}
