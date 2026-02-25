package tn.esprit.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.demo.entity.Course;
import tn.esprit.spring.demo.entity.Support;
import tn.esprit.spring.demo.entity.TypeCourse;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    //finders and keywords
    Course findByLevelAndTypeCourse(int level, TypeCourse typeCourse);
    Course findByPrice(Float price);

    List<Course> findByLevel(int level);
    List<Course> findByTypeCourse(TypeCourse typeCourse);
    List<Course> findBySupport(Support support);
    List<Course> findByPriceBetween(Float minPrice, Float maxPrice);

    @Query("SELECT c FROM Course c JOIN c.registrations r WHERE r.numRegistration = :numRegistration")
    Course findByRegistrationId(@Param("numRegistration") Long numRegistration);

    @Query("SELECT c FROM Course c WHERE c.level >= :minLevel AND c.level <= :maxLevel")
    List<Course> findByLevelRange(@Param("minLevel") int minLevel, @Param("maxLevel") int maxLevel);

}
