package com.istinL3.GestionStock.Services;

import com.istinL3.GestionStock.Model.User;
import com.istinL3.GestionStock.Model.UserPrincipal;
import com.istinL3.GestionStock.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailService  implements UserDetailsService {
    @Autowired(required=true)
    private UserRepo userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(user);
    }

    public User SaveUser(User user){
        return userRepository.save(user);
    }
}
