package tn.esprit.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.demo.entity.Registration;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    //finders and keywords
    Registration findByNumRegistration(Long numRegistration);
    Registration findByNumWeekAndSkier(Long numWeek, Long skierId);

    List<Registration> findByNumWeek(int numWeek);
    List<Registration> findBySkierNumSkier(Long numSkier);
    List<Registration> findByCourseNumCourse(Long numCourse);

    @Query("SELECT r FROM Registration r WHERE r.numWeek >= :startWeek AND r.numWeek <= :endWeek")
    List<Registration> findByWeekRange(@Param("startWeek") int startWeek, @Param("endWeek") int endWeek);

    @Query("SELECT r FROM Registration r JOIN r.course c WHERE c.numCourse = :numCourse")
    List<Registration> findByCourse(@Param("numCourse") Long numCourse);

}
