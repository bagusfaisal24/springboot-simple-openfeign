package openfeign.demo.io_github_openfeign.feign_enable;

import feign.Feign;
import feign.gson.GsonDecoder;
import openfeign.demo.io_github_openfeign.github_followers.GithubFollowersPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubFollowersSvc {
	
	private final String url = "https://api.github.com";
	
	public List<GithubFollowersPojo> encoderData() {
		GithubFollowers githubFollowers = Feign.builder()
				.decoder(new GsonDecoder())
				.target(GithubFollowers.class, url);
		return githubFollowers.followers("bagusfaisal24");
	}
}
