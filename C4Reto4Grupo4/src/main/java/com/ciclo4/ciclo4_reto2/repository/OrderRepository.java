package com.ciclo4.ciclo4_reto2.repository;

import com.ciclo4.ciclo4_reto2.model.Order;
import com.ciclo4.ciclo4_reto2.repository.crud.OrderCrudRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    
    public List<Order> getAll(){
        return orderCrudRepository.findAll();
    }
    
    public Optional<Order> getOrder(Integer id){
        return orderCrudRepository.findById(id);
    }
    
    public Order create(Order order){
        return orderCrudRepository.save(order);
    }
    
    public void update(Order order){
        orderCrudRepository.save(order);
    }
    
    public void delete(Order order){
        orderCrudRepository.delete(order);
    }
    
    public List<Order> getOrdersByZone(String zone){
        return orderCrudRepository.findBySalesManZone(zone);
    }
    public List<Order> getBySalesManId(Integer id){
        return orderCrudRepository.findBySalesManId(id);
    }

    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return orderCrudRepository.findBySalesManIdAndStatus(id, status);
    }
    @Autowired  
    private MongoTemplate mongoTemplate;
    
    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(registerDay, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(registerDay, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);

        return mongoTemplate.find(query,Order.class);
    }


}
/*public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        try {
            return orderCrudRepository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), id);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }*/