package com.ciclo4.ciclo4_reto2.repository.crud;

import com.ciclo4.ciclo4_reto2.model.Order;
import java.util.List;
import java.util.Date;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OrderCrudRepository extends MongoRepository<Order, Integer>{
public  List<Order> findBySalesManZone(String zone);
public  List<Order> findBySalesManId(Integer id);
public  List<Order> findBySalesManIdAndStatus(Integer id, String status);
public  List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer id);
}