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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String saveclient(@ModelAttribute("client") Client client, RedirectAttributes ra){
        ra.addFlashAttribute("message","client ajoute avec succes");
        clientService.saveclient(client);
        return "redirect:/client";
    }
    @GetMapping("/supprimerClient/{id}")
    public String supprimerclient(@PathVariable(value = "id") int id,RedirectAttributes ra){
        ra.addFlashAttribute("message","client supprime avec succes");
        this.clientService.deleteClient(id);
        return "redirect:/client";
    }
}
