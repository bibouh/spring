package com.istinL3.GestionStock.Controller;

import com.istinL3.GestionStock.Model.Client;
import com.istinL3.GestionStock.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/client")
    public String pageClient(Model model){
        Client client = new Client();
        model.addAttribute("client",client) ;
        model.addAttribute("listeClient",clientService.getClients()) ;
        return "client";
    }

    @PostMapping("/saveClient")
    public String saveclient(@ModelAttribute("client") Client client){
        clientService.saveclient(client);
        return "redirect:/client";
    }
    @GetMapping("/supprimerClient/{id}")
    public String supprimerclient(@PathVariable(value = "id") int id){
        this.clientService.deleteClient(id);
        return "redirect:/client";
    }
}
