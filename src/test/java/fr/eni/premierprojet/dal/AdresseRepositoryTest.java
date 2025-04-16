package fr.eni.premierprojet.dal;


import fr.eni.premierprojet.bo.Adresse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AdresseRepositoryTest {

    @Autowired
    private AdresseRepository adresseRepository;

    @Test
    public void testInsertAddress() {

        Adresse adresse = new Adresse();
        adresse.setRue("1 Rue Stique");
        adresse.setVille("Paris");
        adresse.setCodePostal("75000");

        Adresse savedAdresse = adresseRepository.save(adresse);

        assertThat(savedAdresse).isNotNull();
        assertThat(savedAdresse.getId()).isNotNull();
        assertThat(savedAdresse.getRue()).isEqualTo("1 Rue Stique");
        assertThat(savedAdresse.getVille()).isEqualTo("Paris");
        assertThat(savedAdresse.getCodePostal()).isEqualTo("75000");
    }
}