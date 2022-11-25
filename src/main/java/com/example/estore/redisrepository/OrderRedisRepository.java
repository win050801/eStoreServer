package com.example.estore.redisrepository;

import com.example.estore.entity.Order;
import com.example.estore.redisentity.ROrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


public interface OrderRedisRepository extends CrudRepository<ROrder,Integer> {
    List<ROrder> findByCustomerId(String id);
}
