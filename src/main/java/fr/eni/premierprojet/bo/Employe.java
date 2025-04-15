package fr.eni.premierprojet.bo;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
//@Builder
@Entity
@Table(name = "EMPLOYES")
public class Employe {
    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    @Column(length = 50, nullable = false)
    private String nom;

    @NonNull
    @Column(length = 50, nullable = false)
    private String prenom;

    @Column(unique = true, nullable = false)
    @NonNull
    private String email;

    @Basic(optional = true)
    private String telephone;

    @Transient       //permet d'empêcher le stockage de l'attribut en BD
    private String maVariableDeTravail;


}
