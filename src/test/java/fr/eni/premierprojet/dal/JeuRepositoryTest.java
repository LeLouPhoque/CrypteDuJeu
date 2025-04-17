package fr.eni.premierprojet.dal;


import fr.eni.premierprojet.bo.Genre;
import fr.eni.premierprojet.bo.Jeu;
import fr.eni.premierprojet.helper.ObjectBuilder;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
public class JeuRepositoryTest {

    @Autowired
    private JeuRepository jeuRepository;

    @Autowired
    private ObjectBuilder builder;

    @Test
    public void testInsertJeuAvecGenres() {
        // GIVEN
        Jeu saved = jeuRepository.save(builder.jeuBuild());

        // THEN
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getGenres()).hasSize(3);
    }
}
