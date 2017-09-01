package com.inspi01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspi01.domain.User;
import com.inspi01.repository.UserRepository;

/**
 * @author Inspireso Team
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void save(User user){
        userRepository.save(user);
    }

}
