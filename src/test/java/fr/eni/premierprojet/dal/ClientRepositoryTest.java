package fr.eni.premierprojet.dal;

import fr.eni.premierprojet.bo.Adresse;
import fr.eni.premierprojet.bo.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testInsertClient() {

        Adresse adresse = new Adresse();
        adresse.setRue("88 Rue Blanc");
        adresse.setVille("Paris");
        adresse.setCodePostal("75000");

        Client client = new Client();
        client.setNom("Z");
        client.setPrenom("Le");
        client.setTelephone("1234567890");
        client.setEmail("ma.france@gmail.com");
        client.setAdresse(adresse);

        Client savedClient = clientRepository.save(client);

        assertThat(savedClient).isNotNull();
        assertThat(savedClient.getNom()).isEqualTo("Z");
        assertThat(savedClient.getPrenom()).isEqualTo("Le");
        assertThat(savedClient.getTelephone()).isEqualTo("1234567890");
        assertThat(savedClient.getEmail()).isEqualTo("ma.france@gmail.com");
        assertThat(savedClient.getAdresse().getRue()).isEqualTo("88 Rue Blanc");
        assertThat(savedClient.getAdresse().getVille()).isEqualTo("Paris");
        assertThat(savedClient.getAdresse().getCodePostal()).isEqualTo("75000");

    }
}
