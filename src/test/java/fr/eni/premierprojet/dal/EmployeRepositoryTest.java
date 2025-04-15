package fr.eni.premierprojet.dal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class EmployeRepositoryTest {

    @Autowired
    private EmployeRepository repo;

    @Test
    @Transactional
    public void testCreationEmploye() {
        //AAA
        //Arrange : préparation du test
        Employe emp = new Employe("Smith", "Bob", "Smith@gmail.com");

        //Act
        repo.save(emp);

        //Assert
        assertThat(emp.getId()).isNotNull();
        Employe empBD = repo.findById(emp.getId()).get();
        log.info(empBD.toString());
        assertThat(empBD.getNom()).isEqualTo(emp.getNom());
        assertThat(empBD.getPrenom()).isEqualTo(emp.getPrenom());



    }

}