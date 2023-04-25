package com.springboot.test;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * redis事务
 */
public class RedisTest {
    @Resource
    private RedisTemplate redisTemplate;

    //记录实际卖出的商品数量
    private AtomicInteger successNum = new AtomicInteger(0);

    @GetMapping(value = "/reduce")


    // 减库存方法
    public String reduce() {
        // 开启事务
        redisTemplate.setEnableTransactionSupport(true);
        List<Object> results = (List<Object>) redisTemplate.execute(new SessionCallback<List<Object>>() {
            @Override
            public List<Object> execute(RedisOperations operations) throws DataAccessException {
                // 监视key
                operations.watch("awardid_stock");
                Integer stock = (Integer) operations.opsForValue().get("awardid_stock");
                operations.multi();
                stock = stock - 1;
                if (stock < 0) {
                    System.out.println("===>>>库存不足");
                    return null;
                }
                operations.opsForValue().set("awardid_stock", stock);
                return operations.exec();
            }
        });
        if (results != null && results.size() > 0) {
            System.out.println("===>>>减少库存成功");
            return "减少库存成功";
        }
        return "库存不足";
    }
}
