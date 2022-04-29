package com.istinL3.GestionStock.Services;

import com.istinL3.GestionStock.Model.Client;

import java.util.List;

public interface ClientService {
    Client saveclient(Client client);
    List<Client> getClients();
    void deleteClient(int id);
    Client getClient(int id);
    Client updateclient(int id);

}
