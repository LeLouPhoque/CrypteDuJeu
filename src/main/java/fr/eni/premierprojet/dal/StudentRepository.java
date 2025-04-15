package fr.eni.premierprojet.dal;

import fr.eni.premierprojet.bo.Student;
import fr.eni.premierprojet.bo.StudentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, StudentId> {
}
