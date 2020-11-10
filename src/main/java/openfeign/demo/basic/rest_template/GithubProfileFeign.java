package openfeign.demo.basic.rest_template;

import openfeign.demo.basic.profile_pojo.ProfileDataPojo;

public interface GithubProfileFeign {

	ProfileDataPojo getDataProfile();
}
