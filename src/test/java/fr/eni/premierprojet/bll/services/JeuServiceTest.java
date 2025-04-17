package fr.eni.premierprojet.bll.services;

import fr.eni.premierprojet.bo.Jeu;
import fr.eni.premierprojet.dal.JeuRepository;
import fr.eni.premierprojet.helper.ObjectBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class JeuServiceTest {
    @Autowired
    private ObjectBuilder builder;

    @Mock
    private JeuRepository jeuRepository;

    @InjectMocks
    private JeuServiceImpl jeuService;

    @Test
    void testInsertJeuWithGenres() {
        Jeu jeu = builder.jeuBuild();

        Mockito.when(jeuRepository.save(jeu)).thenReturn(jeu);
        Jeu savedJeu = jeuService.insert(jeu);

        Assertions.assertNotNull(savedJeu);
        Assertions.assertEquals("Zelda", savedJeu.getTitre());
        Assertions.assertEquals(3, savedJeu.getGenres().size());
        Mockito.verify(jeuRepository).save(jeu);
    }
}
