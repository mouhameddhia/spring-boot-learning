package tn.esprit.spring.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "instructor")
@NoArgsConstructor
@AllArgsConstructor
@Builder  // Lombok builder
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_instructor")
    private Long numInstructor;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_hire")
    @Temporal(TemporalType.DATE)
    private Date dateOfHire;

    @OneToMany
    private Set<Course> courses;

    // Getters and Setters
    public Long getNumInstructor() {
        return numInstructor;
    }

    public void setNumInstructor(Long numInstructor) {
        this.numInstructor = numInstructor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(Date dateOfHire) {
        this.dateOfHire = dateOfHire;
    }
}