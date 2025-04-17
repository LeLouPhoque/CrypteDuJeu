package fr.eni.premierprojet.bll.services;

import fr.eni.premierprojet.bo.Exemplaire;
import fr.eni.premierprojet.bo.Genre;
import fr.eni.premierprojet.dal.ExemplaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ExemplaireServiceImpl implements ExemplaireService {

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Override
    public List<Exemplaire> findAll() {
        return exemplaireRepository.findAll();
    }

    @Override
    public List<Exemplaire> findAllAvailableByTitre(String titre) {
        return exemplaireRepository.findByEtatAndJeu_TitreContaining("Louable", titre);
    }

    @Override
    public List<Exemplaire> findAllAvailableByGenres(Set<Genre> genres) {
        return exemplaireRepository.findByEtatAndJeu_Genres("Louable", genres);
    }

    @Override
    public List<Exemplaire> findAllAvailableByTitreAndGenres(String titre, Set<Genre> genres) {
        return exemplaireRepository.findByEtatAndJeu_TitreContainingAndJeu_Genres("Louable", titre, genres);
    }
}
