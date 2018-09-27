package com.springboot.redis;

import com.springboot.redis.pojo.User;
import com.springboot.redis.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Resource(name = "stringRedisTemplate")
	private StringRedisTemplate stringRedisTemplate;

	@Resource(name="redisTemplate")
	private RedisTemplate redisTemplate;

	@Resource
	private ValueOperations<String,Object> valueOperations;

	@Autowired
	private HashOperations<String, String, Object> hashOperations;

	@Autowired
	private ListOperations<String, Object> listOperations;

	@Autowired
	private SetOperations<String, Object> setOperations;

	@Autowired
	private ZSetOperations<String, Object> zSetOperations;

	@Resource
	private RedisService redisService;
	@Test
	public void testObj(){
		User user=new User();
		user.setName("rocky");
		user.setAge(18);

		valueOperations.set("user3",user);
		boolean b =redisTemplate.expire("user3",10, TimeUnit.SECONDS);

		System.out.println(b);
	}

	@Test
	public void testString(){

		valueOperations.set("c","jack");

	}

	@Test
	public void deleteKey(){
		redisService.deleteKey("user");
		boolean user = redisService.existsKey("user");
		System.out.println(user);
	}

}
