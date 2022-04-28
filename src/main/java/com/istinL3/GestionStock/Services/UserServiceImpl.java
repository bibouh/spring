package com.istinL3.GestionStock.Services;

import com.istinL3.GestionStock.Model.Article;
import com.istinL3.GestionStock.Model.User;
import com.istinL3.GestionStock.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public User saveuser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getUser(int id) {
        Optional<User> userOptional = userRepo.findById(id);
        User user =null;
        if (userOptional.isPresent()){
            user = userOptional.get();
        }else {
            throw new RuntimeException("User nom trouver"+id) ;
        }
        return user;    }

    @Override
    public User updateutilisateur(int id) {
        return null;
    }
}
