package openfeign.demo.io_github_openfeign.user;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("USER")
public class UserPojo implements Serializable {

	private Long id;

	private String username;
}
