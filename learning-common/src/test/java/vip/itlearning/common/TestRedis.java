package vip.itlearning.common;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
public class TestRedis {

    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    @Test
    void getName() {
        // redisTemplate  #操作不同的数据类型，api和我们的指令是一样的
        // opsForValue  #操作字符串 类似String
        // opsForList  #操作List 类似List
        // opsForSet  #操作set
        // opsForHash  #操作hash
        // opsForZSet  #操作zset
        // opsForGeo   #操作geo
        // opsForHyperLogLog  #操作HyperLogLog
        // 除了进本的操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务，和基本的 CRUD
        // 获取redis的连接对象
        // RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        // connection.flushDb();
        // connection.flushAll();

        redisTemplate.opsForValue().set("name", "dadadingdada!");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }
}
