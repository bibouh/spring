package com.istinL3.GestionStock;

import com.istinL3.GestionStock.Model.User;
import com.istinL3.GestionStock.Repository.UserRepo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GestionStockApplication implements CommandLineRunner {
    @Autowired
    private UserRepo userRepo;


	public static void main(String[] args) {
		SpringApplication.run(GestionStockApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userRepo.save(new User("admin" ,"admin","admin@gmail.com",bCryptPasswordEncoder.encode("admin")));
    }
}
