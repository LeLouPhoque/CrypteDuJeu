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

    @Column()
    private String reference;

    @Column()
    private int ageMin;

    @Column()
    private String description;

    @Column()
    private int dureeMoyenne;

    @Column()
    private double tarifJournalier;

    @ManyToMany
    private Set<Genre> genres = new HashSet<>();
}
