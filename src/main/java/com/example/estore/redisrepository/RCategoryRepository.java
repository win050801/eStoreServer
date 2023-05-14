//package com.example.estore.redisrepository;
//
//import com.example.estore.redisentity.RCategory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class RCategoryRepository {
//    @Autowired
//    private RedisTemplate redisTemplate;
//    public List<RCategory> findAll(){
//        System.out.println("Call from DB");
//        List<RCategory> list = redisTemplate.opsForHash().values("Categories");
//        return redisTemplate.opsForHash().values("Categories");
//    }
//}
