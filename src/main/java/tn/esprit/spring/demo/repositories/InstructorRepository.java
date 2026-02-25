package tn.esprit.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.demo.entity.Instructor;

import java.util.Date;
import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    //finders and keywords
    Instructor findByFirstNameAndLastName(String firstName, String lastName);
    Instructor findByNumInstructor(Long numInstructor);

    List<Instructor> findByFirstName(String firstName);
    List<Instructor> findByLastName(String lastName);
    List<Instructor> findByDateOfHire(Date dateOfHire);

    @Query("SELECT i FROM Instructor i JOIN i.courses c WHERE c.numCourse = :numCourse")
    List<Instructor> findByCourseId(@Param("numCourse") Long numCourse);

    @Query("SELECT i FROM Instructor i WHERE i.dateOfHire >= :startDate AND i.dateOfHire <= :endDate")
    List<Instructor> findByHireDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
