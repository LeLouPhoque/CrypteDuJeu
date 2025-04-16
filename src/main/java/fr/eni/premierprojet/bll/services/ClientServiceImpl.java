package fr.eni.premierprojet.bll.services;

import fr.eni.premierprojet.bo.Adresse;
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

    @Override
    public Client update(Client client) {
        return update(client.getId(), client.getNom(), client.getPrenom(), client.getEmail(), client.getTelephone(), client.getAdresse());
    }

    @Override
    public Client update(Long id, String nom, String prenom, String email, String telephone, Adresse adresse) {
        return update(id, nom, prenom, email, telephone, adresse.getRue(), adresse.getVille(), adresse.getCodePostal());
    }

    @Override
    public Client update(Long id, String nom, String prenom, String email, String telephone, String rue, String ville, String codePostal) {
        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();

            client.setNom(nom);
            client.setPrenom(prenom);
            client.setEmail(email);
            client.setTelephone(telephone);

            Adresse adresse = client.getAdresse();
            adresse.setRue(rue);
            adresse.setVille(ville);
            adresse.setCodePostal(codePostal);

            client.setAdresse(adresse);

            return clientRepository.save(client);
        } else {
            throw new RuntimeException("Le client n'existe pas");
        }
    }
}
