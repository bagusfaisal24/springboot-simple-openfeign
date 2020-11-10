package openfeign.demo.io_github_openfeign.github_followers;

import openfeign.demo.io_github_openfeign.feign_enable.GithubFollowersSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/followers")
public class GithubFollowersController {
	
	private GithubFollowersSvc githubFollowersSvc;
	
	@Autowired
	public GithubFollowersController(GithubFollowersSvc githubFollowersSvc) {
		this.githubFollowersSvc = githubFollowersSvc;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<GithubFollowersPojo> getFollowers(){
		return githubFollowersSvc.encoderData();
	}
}
