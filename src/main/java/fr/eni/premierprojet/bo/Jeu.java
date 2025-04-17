package fr.eni.premierprojet.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jeu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String reference;

    @Column(nullable = false)
    private int ageMin;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int dureeMoyenne;

    @Column(nullable = false)
    private double tarifJournalier;

    @ManyToMany
    private Set<Genre> genres = new HashSet<>();

    @OneToMany(mappedBy = "jeu")
    private Set<Exemplaire> exemplaires = new HashSet<>();
}
