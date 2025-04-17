package fr.eni.premierprojet.bll.services;

import fr.eni.premierprojet.bo.Exemplaire;
import fr.eni.premierprojet.bo.Genre;

import java.util.List;
import java.util.Set;

public interface ExemplaireService {

    List<Exemplaire> findAll();

    List<Exemplaire> findAllAvailableByTitre(String titre);

    List<Exemplaire> findAllAvailableByGenres(Set<Genre> genres);

    List<Exemplaire> findAllAvailableByTitreAndGenres(String titre, Set<Genre> genres);
}
