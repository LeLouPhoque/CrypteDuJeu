package fr.eni.premierprojet.dal;

import fr.eni.premierprojet.bo.Genre;
import fr.eni.premierprojet.bo.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
