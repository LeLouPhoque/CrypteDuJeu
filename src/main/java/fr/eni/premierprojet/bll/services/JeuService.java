package fr.eni.premierprojet.bll.services;

import fr.eni.premierprojet.bo.Genre;
import fr.eni.premierprojet.bo.Jeu;

import java.util.List;
import java.util.Set;

public interface JeuService {

    Jeu insert(Jeu jeu);

    List<Jeu> findAll();

    List<Jeu> findAllByTitre(String titre);

    List<Jeu> findAllByGenres(Set<Genre> genres);

    List<Jeu> findAllByTitreAndGenres(String titre, Set<Genre> genres);
}
