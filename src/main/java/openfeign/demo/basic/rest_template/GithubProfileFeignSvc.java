package openfeign.demo.basic.rest_template;

import openfeign.demo.basic.profile_pojo.ProfileDataPojo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class GithubProfileFeignSvc implements GithubProfileFeign {
	
	@Override
	public ProfileDataPojo getDataProfile() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ProfileDataPojo> responseEntity = restTemplate.getForEntity("https://api.github.com/users/bagusfaisal24", ProfileDataPojo.class);
		ProfileDataPojo profileData = new ProfileDataPojo();
		profileData.setName(Objects.requireNonNull(responseEntity.getBody()).getName());
		profileData.setCompany(responseEntity.getBody().getCompany());
		return profileData;
	}
}
