package com.istinL3.GestionStock.Controller;


import com.istinL3.GestionStock.Model.User;
import com.istinL3.GestionStock.Services.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private MyUserDetailService myUserDetailService;


    @GetMapping("/login")
    public String loginpage(){
        return "auth-login";
    }

    @GetMapping("/")
    public String indexpage(){
        return "index";
    }

    @GetMapping("/register")
    public String registerpage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }

    @PostMapping("/save")
    public String registerpage(@ModelAttribute("user") User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        myUserDetailService.SaveUser(user);
        return "redirect:/register";
    }

}
