package fr.eni.premierprojet.bll.services;

import fr.eni.premierprojet.bo.Genre;
import fr.eni.premierprojet.bo.Jeu;
import fr.eni.premierprojet.dal.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class JeuServiceImpl implements JeuService {

    @Autowired
    private JeuRepository jeuRepository;

    @Override
    public Jeu insert(Jeu jeu) {
        return jeuRepository.save(jeu);
    }

    @Override
    public List<Jeu> findAll() {
        return jeuRepository.findAll();
    }

    @Override
    public List<Jeu> findAllByTitre(String titre) {
        return jeuRepository.findAllByTitreContaining(titre);
    }

    @Override
    public List<Jeu> findAllByGenres(Set<Genre> genres) {
        return jeuRepository.findAllByGenres(genres);
    }

    @Override
    public List<Jeu> findAllByTitreAndGenres(String titre, Set<Genre> genres) {
        return jeuRepository.findByTitreContainingAndGenres(titre, genres);
    }
}
