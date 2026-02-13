package tn.esprit.spring.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "skier")
@NoArgsConstructor
@AllArgsConstructor
@Builder  // Lombok builder
public class Skier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_skier")
    private Long numSkier;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "city")
    private String city;

    @ManyToMany
    private Set<Piste> pistes;

    @OneToMany(mappedBy = "skier")
    private Set<Registration> registrations;

    @OneToOne(cascade = CascadeType.ALL)  // strong relationship
    private Subscription subscription;

    // Getters and Setters
    public Long getNumSkier() {
        return numSkier;
    }

    public void setNumSkier(Long numSkier) {
        this.numSkier = numSkier;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}