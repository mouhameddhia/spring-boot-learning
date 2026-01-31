package tn.esprit.spring.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Entity
@Getter
@Setter

public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Name;

    @OneToMany(mappedBy = "departement")
    private List<Etudiant> students;

    public Departement() {
    }
}
