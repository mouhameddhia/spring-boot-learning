package tn.esprit.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.demo.entity.Color;
import tn.esprit.spring.demo.entity.Piste;

import java.util.List;


public interface PisteRepository extends JpaRepository<Piste, Long> {

    //finders and keywords
    Piste findByColorAndSlope(Color color , int slope);
    Piste findByNamePiste(String namePiste);
    List <Piste> findByColor(Color color);
    List<Piste> findByLength(int length);


    @Query("SELECT p FROM Piste p JOIN p.skiers s WHERE s.numSkier = :numSkier")
    List<Piste> findByNumSkier(@Param("numSkier") Long numSkier);

    @Query("SELECT p FROM Piste p WHERE p.length >= :minLength AND p.length <= :maxLength")
    List <Piste> findByLength(@Param("minLength") int minLength, @Param("maxLength") int  maxLength);

}