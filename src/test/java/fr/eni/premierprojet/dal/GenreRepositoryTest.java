package fr.eni.premierprojet.dal;


import fr.eni.premierprojet.bo.Adresse;
import fr.eni.premierprojet.bo.Genre;
import fr.eni.premierprojet.helper.ObjectBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    private final ObjectBuilder builder;

    public GenreRepositoryTest(ObjectBuilder builder) {
        this.builder = builder;
    }

    @Test
    public void testInsertGenre() {

        Genre genre = builder.genresBuild().stream().findFirst().get();

        Genre savedGenre = genreRepository.save(genre);

        assertThat(savedGenre).isNotNull();
        assertThat(savedGenre.getNom()).isEqualTo(genre.getNom());
    }
}