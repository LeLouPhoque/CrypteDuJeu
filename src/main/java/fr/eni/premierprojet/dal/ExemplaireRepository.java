package fr.eni.premierprojet.dal;

import fr.eni.premierprojet.bo.Exemplaire;
import fr.eni.premierprojet.bo.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ExemplaireRepository extends JpaRepository<Exemplaire, Long> {
    List<Exemplaire> findByEtatAndJeu_TitreContaining(String etat, String titre);
    List<Exemplaire> findByEtatAndJeu_Genres(String etat, Set<Genre> genres);
    List<Exemplaire> findByEtatAndJeu_TitreContainingAndJeu_Genres(String etat, String titre, Set<Genre> genres);
}
