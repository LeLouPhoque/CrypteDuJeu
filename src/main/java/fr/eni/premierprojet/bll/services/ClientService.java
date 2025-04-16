package fr.eni.premierprojet.bll.services;

import fr.eni.premierprojet.bo.Client;

public interface ClientService {

    Client insert(Client client);

    Client findByNom(String nom);
}
