package fr.eni.premierprojet.dal;

import fr.eni.premierprojet.bo.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {
}
