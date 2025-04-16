package fr.eni.premierprojet.dal;

import fr.eni.premierprojet.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findUniqueByNom(String nom);
    List<Client> findByNom(String nom);
}
