import com.kevin.RedisApplication;
import com.kevin.entity.Users;
import com.kevin.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author kevin
 * @version 1.0
 * @description     测试redis
 * @createDate 2019/3/22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class RedisTest {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    // 测试封装的RedisService    插入数据
    @Test
    public void testSet() {
        // 通过redisService将key-value键值对数据插入redis，设置生命周期，5分钟
        redisService.set("tomcat","广州",60*5);
        redisService.set("netty","广州",60*5);
    }

    // 测试原生的RedisTemplate       插入数据
    @Test
    public void testTemplate(){
        // 通过redisTemplate将key-value键值对数据插入redis，设置生命周期，5分钟
        redisTemplate.opsForValue().set("java","广州",60*5, TimeUnit.SECONDS);
    }

    // 测试封装的RedisService        基于JSON格式存储Users对象
    @Test
    public void testSetUserJson(){
        Users users = new Users();
        users.setName("kevin");
        users.setAge(22);
        users.setId(1);
        // 基于JSON格式存储Users对象
        redisService.setModel("users_json", users, Users.class, 60*2);
    }

    // 测试封装的RedisService        基于JSON格式取Users对象
    @Test
    public void testGetUserJson(){
        // 基于JSON格式取Users对象
        Users users = redisService.getModel("users_json", Users.class);
        System.out.println(users);
    }


    // 测试原生的RedisTemplate        基于JSON格式存储Users对象
    @Test
    public void testSetUserJsonTemplate(){
        Users users = new Users();
        users.setName("kevin");
        users.setAge(22);
        users.setId(1);
        // 基于JSON格式存储Users对象
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        redisTemplate.opsForValue().set("users_json",users);
    }

    // 测试原生的RedisTemplate        基于JSON格式取Users对象
    @Test
    public void testGetUserJsonTemplate(){
        // 基于JSON格式取Users对象
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
        Users usersJson = (Users)this.redisTemplate.opsForValue().get("users_json");
        System.out.println(usersJson);
    }
}
