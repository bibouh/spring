package com.istinL3.GestionStock.Controller;
import com.istinL3.GestionStock.Model.User;
import com.istinL3.GestionStock.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/utilisateur")
    public String pageUser(Model model){
       User user = new User();
        model.addAttribute("user",user) ;
        model.addAttribute("listeUser",userService.getUsers()) ;
        return "user";
    }

    @PostMapping("/saveUser")
    public String saveuser(@ModelAttribute("client") User user){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.saveuser(user);
        return "redirect:/utilisateur";
    }
    @GetMapping("/supprimerUser/{id}")
    public String supprimeruser(@PathVariable(value = "id") int id){
        this.userService.deleteUser(id);
        return "redirect:/utilisateur";
    }
}
