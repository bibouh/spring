package com.istinL3.GestionStock.Services;

import com.istinL3.GestionStock.Model.Client;
import com.istinL3.GestionStock.Repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepo clientRepo;
    @Override
    public Client saveclient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public List<Client> getClients() {
        return clientRepo.findAll();
    }

    @Override
    public void deleteClient(int id) {
     clientRepo.deleteById(id);
    }

    @Override
    public Client getClient(int id) {
        Optional<Client> clientOptional = clientRepo.findById(id);
        Client client =null;
        if (clientOptional.isPresent()){
            client = clientOptional.get();
        }else {
            throw new RuntimeException("Client nom trouver"+id) ;
        }
        return client;
    }

    @Override
    public Client updateclient(int id) {
        return null;
    }
}
