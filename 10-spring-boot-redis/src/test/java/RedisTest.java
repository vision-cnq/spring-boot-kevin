import com.kevin.RedisApplication;
import com.kevin.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author kevin
 * @version 1.0
 * @description
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
}
