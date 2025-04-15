package fr.eni.premierprojet.dal;

import fr.eni.premierprojet.bo.Adresse;
import fr.eni.premierprojet.bo.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuRepository extends JpaRepository<Jeu, Long> {
}
