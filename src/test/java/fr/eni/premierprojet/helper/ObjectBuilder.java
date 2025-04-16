package fr.eni.premierprojet.helper;


import fr.eni.premierprojet.bo.Exemplaire;
import fr.eni.premierprojet.bo.Genre;
import fr.eni.premierprojet.bo.Jeu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@Slf4j
public class ObjectBuilder {

    public Set<Genre> genresBuild() {
        Set<Genre> genres = new HashSet<>();

        Genre genre1 = Genre.builder().nom("énigme").build();
        Genre genre2 = Genre.builder().nom("aventure").build();
        Genre genre3 = Genre.builder().nom("action").build();

        genres.add(genre1);
        genres.add(genre2);
        genres.add(genre3);

        return genres;
    }

    public Jeu jeuBuild() {
        Set<Genre> genres = genresBuild();

        return Jeu.builder()
                .titre("Zelda")
                .reference("ZLD-001")
                .ageMin(12)
                .description("Un jeu d’aventure épique")
                .dureeMoyenne(120)
                .tarifJournalier(4.99)
                .genres(genres)
                .build();
    }

    public Exemplaire exemplaireBuild() {
        Jeu jeu = jeuBuild();

        return Exemplaire.builder()
                .codeBarre("123456789")
                .etat("Neuf")
                .jeu(jeu)
                .build();
    }
}