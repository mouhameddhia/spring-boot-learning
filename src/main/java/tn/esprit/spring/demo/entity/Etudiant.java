
package tn.esprit.spring.demo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table( name ="Etudiant")
@Getter
@Setter

public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;


    @ManyToOne
    private Departement departement;

    // Constructeur et accesseurs (getters) et mutateurs (setters)
    public Etudiant() {
    }




}
