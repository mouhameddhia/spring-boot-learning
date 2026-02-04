package tn.esprit.spring.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "piste")
@NoArgsConstructor
@AllArgsConstructor
@Builder  // Lombok builder
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_piste")
    private Long numPiste;

    @Column(name = "name_piste")
    private String namePiste;

    @Enumerated(EnumType.STRING)  // now it's correct
    @Column(name = "color")
    private Color color;

    @Column(name = "length")
    private int length;

    @Column(name = "slope")
    private int slope;


    // Getters and Setters
    public Long getNumPiste() {
        return numPiste;
    }

    public void setNumPiste(Long numPiste) {
        this.numPiste = numPiste;
    }

    public String getNamePiste() {
        return namePiste;
    }

    public void setNamePiste(String namePiste) {
        this.namePiste = namePiste;
    }

    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }


    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public int getSlope() {
        return slope;
    }

    public void setSlope(int slope) {
        this.slope = slope;
    }
}