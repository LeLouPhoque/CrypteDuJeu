package fr.eni.premierprojet.bll.services;

import fr.eni.premierprojet.bo.Adresse;
import fr.eni.premierprojet.bo.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client insert(Client client);

    Optional<Client> findByNom(String nom);

    List<Client> findAllByNom(String nom);

    Client update(Client client);

    Client update(Long id, String nom, String prenom, String email, String telephone, Adresse adresse);

    Client update(Long id, String nom, String prenom, String email, String telephone, String rue, String ville, String codePostal);
}
