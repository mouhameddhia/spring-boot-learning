package tn.esprit.spring.demo.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "registration")
@NoArgsConstructor
@AllArgsConstructor
@Builder  // Lombok builder
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_registration")
    private Long numRegistration;

    @Column(name = "num_week")
    private int numWeek;

    @ManyToOne
    private Skier skier;

    @ManyToOne
    @JoinColumn(name = "course_id")  // foreign key column
    private Course course;


    public Registration(int numWeek) {
        this.numWeek = numWeek;
    }

    // Getters and Setters
    public Long getNumRegistration() {
        return numRegistration;
    }

    public void setNumRegistration(Long numRegistration) {
        this.numRegistration = numRegistration;
    }

    public int getNumWeek() {
        return numWeek;
    }

    public void setNumWeek(int numWeek) {
        this.numWeek = numWeek;
    }
}