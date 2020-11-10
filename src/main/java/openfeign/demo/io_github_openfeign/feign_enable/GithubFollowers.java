package openfeign.demo.io_github_openfeign.feign_enable;

import feign.Param;
import feign.RequestLine;
import openfeign.demo.io_github_openfeign.github_followers.GithubFollowersPojo;

import java.util.List;

public interface GithubFollowers {
	
	@RequestLine("GET /users/{owner}/followers")
	List<GithubFollowersPojo> followers (@Param("owner") String owner);
}
