package fr.eni.premierprojet.dal;

import fr.eni.premierprojet.bo.Genre;
import fr.eni.premierprojet.bo.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface JeuRepository extends JpaRepository<Jeu, Long> {
    List<Jeu> findAllByTitreContaining(String titre);
    List<Jeu> findAllByGenres(Set<Genre> genres);
    List<Jeu> findByTitreContainingAndGenres(String titre, Set<Genre> genres);
}
