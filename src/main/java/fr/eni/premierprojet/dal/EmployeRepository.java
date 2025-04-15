package fr.eni.premierprojet.dal;

import fr.eni.premierprojet.bo.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
}
