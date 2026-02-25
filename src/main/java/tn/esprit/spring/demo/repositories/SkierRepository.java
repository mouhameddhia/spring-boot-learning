package tn.esprit.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.demo.entity.Skier;

import java.util.List;

public interface SkierRepository extends JpaRepository<Skier, Long> {

    // Single-object finders
    Skier findByNumSkier(Long numSkier);
    Skier findByFirstnameAndLastname(String firstname, String lastname);

    // List-based finders
    List<Skier> findByCity(String city);
    List<Skier> findByDateOfBirthBetween(java.util.Date startDate, java.util.Date endDate);

    // Relationship-based queries
    @Query("SELECT s FROM Skier s JOIN s.pistes p WHERE p.numPiste = :numPiste")
    List<Skier> findByPiste(@Param("numPiste") Long numPiste);

    @Query("SELECT s FROM Skier s JOIN s.registrations r WHERE r.numWeek = :numWeek")
    List<Skier> findByRegistrationWeek(@Param("numWeek") int numWeek);

}
