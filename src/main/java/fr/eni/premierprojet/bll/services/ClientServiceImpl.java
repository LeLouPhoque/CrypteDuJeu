package fr.eni.premierprojet.bll.services;

import fr.eni.premierprojet.bo.Client;
import fr.eni.premierprojet.dal.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client insert(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findByNom(String nom) {
        try {
            return clientRepository.findUniqueByNom(nom);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Client> findAllByNom(String nom) {
        return clientRepository.findByNom(nom);
    }
}
