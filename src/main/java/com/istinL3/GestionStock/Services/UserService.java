package com.istinL3.GestionStock.Services;

import com.istinL3.GestionStock.Model.User;

import java.util.List;

public interface UserService {
    User saveuser(User user);
    List<User> getUsers();
    void deleteUser(int id);
    User getUser(int id);
    User updateutilisateur(int id);
}
