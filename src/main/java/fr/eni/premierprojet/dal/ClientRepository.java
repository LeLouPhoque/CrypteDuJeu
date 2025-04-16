package fr.eni.premierprojet.dal;

import fr.eni.premierprojet.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByNom(String nom);
}
