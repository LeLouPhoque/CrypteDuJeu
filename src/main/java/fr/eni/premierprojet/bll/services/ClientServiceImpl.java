package fr.eni.premierprojet.bll.services;

import fr.eni.premierprojet.bo.Client;
import fr.eni.premierprojet.dal.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client insert(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findByNom(String nom) {
        return clientRepository.findByNom(nom);
    }
}
