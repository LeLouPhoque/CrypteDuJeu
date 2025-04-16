package fr.eni.premierprojet.bll.services;

import fr.eni.premierprojet.bo.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client insert(Client client);

    Optional<Client> findByNom(String nom);

    List<Client> findAllByNom(String nom);
}
