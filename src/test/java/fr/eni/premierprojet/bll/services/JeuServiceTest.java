package fr.eni.premierprojet.bll.services;

import fr.eni.premierprojet.bo.Genre;
import fr.eni.premierprojet.bo.Jeu;
import fr.eni.premierprojet.dal.JeuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class JeuServiceTest {

    @Mock
    private JeuRepository jeuRepository;

    @InjectMocks
    private JeuServiceImpl jeuService;

    @Test
    void testInsertJeuWithGenres() {
        Genre genre1 = Genre.builder().id(1L).nom("Stratégie").build();
        Genre genre2 = Genre.builder().id(2L).nom("Aventure").build();
        Set<Genre> genreSet = new HashSet<>(Arrays.asList(genre1, genre2));

        Jeu jeu = Jeu.builder()
                .titre("Jeu test")
                .reference("8675309123456")
                .ageMin(5)
                .description("Un jeu pour faire des tests")
                .dureeMoyenne(25)
                .tarifJournalier(1.5)
                .genres(genreSet)
                .build();

        Mockito.when(jeuRepository.save(jeu)).thenReturn(jeu);
        Jeu savedJeu = jeuService.insert(jeu);

        Assertions.assertNotNull(savedJeu);
        Assertions.assertEquals("Jeu test", savedJeu.getTitre());
        Assertions.assertEquals(2, savedJeu.getGenres().size());
        Mockito.verify(jeuRepository).save(jeu);
    }
}
