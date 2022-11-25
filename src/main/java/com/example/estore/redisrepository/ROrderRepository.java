package com.example.estore.redisrepository;

import com.example.estore.redisentity.RCategory;
import com.example.estore.redisentity.ROrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ROrderRepository {
    @Autowired
    private RedisTemplate redisTemplate;
    public ROrder save(ROrder p) {
        redisTemplate.opsForHash().put("Orders", p.getOrderId(), p);
        return p;
    }
    public List<ROrder> findAll(){
        System.out.println("Call from DB");
        List<ROrder> list = redisTemplate.opsForHash().values("Orders");
        return redisTemplate.opsForHash().values("Orders");
    }
    public ROrder findByCustomerId(int id) {
        return (ROrder) redisTemplate.opsForHash().get("Orders",id);
    }

}
