package com.ciclo4.ciclo4_reto2.service;

import com.ciclo4.ciclo4_reto2.model.User;
import com.ciclo4.ciclo4_reto2.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public User create(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> dbUser = userRepository.getUser(user.getId());
            //if (dbUser.isEmpty()) {
            if (!dbUser.isPresent()) {    
                if (emailExists(user.getEmail()) == false) {
                    return userRepository.create(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }

    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> dbUser = userRepository.getUser(user.getId());
            if (dbUser.isPresent()) {
                if (user.getIdentification() != null) {
                    dbUser.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    dbUser.get().setName(user.getName());
                }
                if (user.getBirthtDay() != null){
                   dbUser.get().setBirthtDay(user.getBirthtDay());
                }
                if (user.getMonthBirthtDay() != null){
                    dbUser.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress() != null) {
                    dbUser.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    dbUser.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    dbUser.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    dbUser.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    dbUser.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    dbUser.get().setType(user.getType());
                }
                userRepository.update(dbUser.get());
                return dbUser.get();
            } else {
                return user;
            }
        }
        return user;
    }

    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    public boolean delete(int userId) {
        Boolean userBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return userBoolean;
    }

    public User authenticateUser(String email, String password){
        Optional<User> user = userRepository.authenticateUser(email, password);
        if (!user.isPresent()){
            return new User();
        }else{
        return user.get();
        }
    }
    public List<User>getByMonthBirthDay(String monthBirthDay){
        return userRepository.getByMonthBirthtDay(monthBirthDay);
}
}