package fr.eni.premierprojet.dal;

import fr.eni.premierprojet.bo.Exemplaire;
import fr.eni.premierprojet.bo.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplaireRepository extends JpaRepository<Exemplaire, Long> {
}
