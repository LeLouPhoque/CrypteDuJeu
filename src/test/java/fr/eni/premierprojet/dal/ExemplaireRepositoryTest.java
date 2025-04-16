package fr.eni.premierprojet.dal;

import fr.eni.premierprojet.bo.Exemplaire;
import fr.eni.premierprojet.helper.ObjectBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Slf4j
class ExemplaireRepositoryTest {
    private final ObjectBuilder builder;

    ExemplaireRepositoryTest(ObjectBuilder builder) {
        this.builder = builder;
    }

    @Test
    public void testExemplairePersisted() {
        Exemplaire exemplaire = builder.exemplaireBuild();

        assertThat(exemplaire.getId()).isNull();
        assertThat(exemplaire.getJeu()).isNotNull();
        assertThat(exemplaire.getCodeBarre()).isEqualTo("123456789");
        assertThat(exemplaire.getEtat()).isEqualTo("Neuf");
    }

}