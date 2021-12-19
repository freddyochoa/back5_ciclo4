package com.ciclo4.ciclo4_reto2.repository;

import com.ciclo4.ciclo4_reto2.model.User;
import com.ciclo4.ciclo4_reto2.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public User create(User user) {
        return userCrudRepository.save(user);
    }

    public void update(User user) {
        userCrudRepository.save(user);
    }

    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    public boolean emailExists(String email) {
        Optional<User> user = userCrudRepository.findByEmail(email);
        return user.isPresent();
    }

    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    public List<User>getByMonthBirthtDay(String monthBirthtDay){
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }
}