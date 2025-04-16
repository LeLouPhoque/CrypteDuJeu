package fr.eni.premierprojet.bll.services;

import fr.eni.premierprojet.bo.Jeu;
import fr.eni.premierprojet.dal.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JeuServiceImpl implements JeuService {

    @Autowired
    private JeuRepository jeuRepository;

    @Override
    public Jeu insert(Jeu jeu) {
        return jeuRepository.save(jeu);
    }
}
