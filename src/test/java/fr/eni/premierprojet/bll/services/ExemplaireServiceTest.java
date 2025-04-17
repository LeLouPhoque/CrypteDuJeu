package fr.eni.premierprojet.bll.services;

import fr.eni.premierprojet.bo.Exemplaire;
import fr.eni.premierprojet.bo.Genre;
import fr.eni.premierprojet.dal.ExemplaireRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class ExemplaireServiceTest {

    @Mock
    private ExemplaireRepository exemplaireRepository;

    @InjectMocks
    private ExemplaireServiceImpl exemplaireService;

    private Set<Genre> genres;
    private String titre;

    @BeforeEach
    void setUp() {
        genres = new HashSet<>(Arrays.asList(Genre.builder().nom("Aventure").build()));
        titre = "Jeu de test";
    }

    @Test
    void testFindAll() {
        Exemplaire exemplaire1 = new Exemplaire();
        Exemplaire exemplaire2 = new Exemplaire();

        Mockito.when(exemplaireRepository.findAll()).thenReturn(List.of(exemplaire1, exemplaire2));

        List<Exemplaire> exemplaires = exemplaireService.findAll();

        Assertions.assertNotNull(exemplaires);
        Assertions.assertEquals(2, exemplaires.size());
        Mockito.verify(exemplaireRepository, Mockito.times(1)).findAll();
    }

    @Test
    void testFindAllAvailableByTitre() {
        Exemplaire exemplaire1 = new Exemplaire();
        Exemplaire exemplaire2 = new Exemplaire();
        String titre = "Test";

        Mockito.when(exemplaireRepository.findByEtatAndJeu_TitreContaining("Louable", titre))
                .thenReturn(List.of(exemplaire1, exemplaire2));

        List<Exemplaire> exemplaires = exemplaireService.findAllAvailableByTitre(titre);

        Assertions.assertNotNull(exemplaires);
        Assertions.assertEquals(2, exemplaires.size());
        Mockito.verify(exemplaireRepository, Mockito.times(1))
                .findByEtatAndJeu_TitreContaining("Louable", titre);
    }

    @Test
    void testFindAllAvailableByGenres() {
        Exemplaire exemplaire1 = new Exemplaire();
        Exemplaire exemplaire2 = new Exemplaire();

        Mockito.when(exemplaireRepository.findByEtatAndJeu_Genres("Louable", genres))
                .thenReturn(List.of(exemplaire1, exemplaire2));

        List<Exemplaire> exemplaires = exemplaireService.findAllAvailableByGenres(genres);

        Assertions.assertNotNull(exemplaires);
        Assertions.assertEquals(2, exemplaires.size());
        Mockito.verify(exemplaireRepository, Mockito.times(1))
                .findByEtatAndJeu_Genres("Louable", genres);
    }

    @Test
    void testFindAllAvailableByTitreAndGenres() {
        Exemplaire exemplaire1 = new Exemplaire();
        Exemplaire exemplaire2 = new Exemplaire();

        Mockito.when(exemplaireRepository.findByEtatAndJeu_TitreContainingAndJeu_Genres("Louable", titre, genres))
                .thenReturn(List.of(exemplaire1, exemplaire2));

        List<Exemplaire> exemplaires = exemplaireService.findAllAvailableByTitreAndGenres(titre, genres);

        Assertions.assertNotNull(exemplaires);
        Assertions.assertEquals(2, exemplaires.size());
        Mockito.verify(exemplaireRepository, Mockito.times(1))
                .findByEtatAndJeu_TitreContainingAndJeu_Genres("Louable", titre, genres);
    }
}
