package fr.eni.premierprojet.bo;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

//@SpringBootTest
@Slf4j
class EmployeTest {

    /* Version 1 - Sans @Builder sur Employe
  @Test
  public void testCreationEmploye() {

        Employe emp = new Employe("Smith", "Bob");

        assertThat(emp).isNotNull();
        assertThat(emp.getId()).isNull();
        assertThat(emp.getNom()).isEqualTo("Smith");
        assertThat(emp.getPrenom()).isEqualTo("Bob");
        assertThat(emp.getEmail()).isNull();

  }
*/

    @Test
    public void testCreationEmploye() {


        /*
        Employe emp = Employe.builder()
                .nom("Smith")
                .prenom("Bob")
                .build();
         */
        Employe emp = new Employe("Smith", "Bob", "Smith@gmail.com");

        log.info(emp.toString());

        assertThat(emp).isNotNull();
        assertThat(emp.getId()).isNull();
        assertThat(emp.getNom()).isEqualTo("Smith");
        assertThat(emp.getPrenom()).isEqualTo("Bob");
        assertThat(emp.getEmail()).isNull();

    }

}