package com.hareket.web.services;

import com.hareket.web.model.User;
import com.hareket.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	@Autowired
    UserRepository userRepository;

	public User findById(Integer id) {
	   return userRepository.findById(id).get ();
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<> ();
        userRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public User save(User user) {
	    return userRepository.save (user);
    }

    public void delete(User user) {
        userRepository.delete (user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById (id);
    }

    public User checkLogin(String code, String password) {
        return userRepository.checkLogin (code, password);
    }

}