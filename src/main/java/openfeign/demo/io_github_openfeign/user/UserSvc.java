package openfeign.demo.io_github_openfeign.user;

import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSvc {

    @Value("${app.uri_backend}")
    @Setter
    private String uri;

    private static final String key = "USER";

    @Autowired
    private RedisTemplate redisTemplate;

    public UserPojo getMe(String access_token) {
        UserClient userClient = Feign.builder()
                .decoder(new GsonDecoder())
                .target(UserClient.class, uri);
        return userClient.getMe(access_token);
    }

    public List<UserPojo> getAll(String access_token) {
        UserClient userClient = Feign.builder()
                .decoder(new GsonDecoder())
                .target(UserClient.class, uri);
        return userClient.getAllUser(access_token);
    }

    public void newArrData(String access_token) {
        try {
            List<UserPojo> listUsers = getAll(access_token);
            for (UserPojo user: listUsers){
                redisTemplate.opsForHash().put(key, user.getId(), user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<UserPojo> getAll (){
        List<UserPojo> allUser;
        allUser = redisTemplate.opsForHash().values(key);
        return allUser;
    }
}
