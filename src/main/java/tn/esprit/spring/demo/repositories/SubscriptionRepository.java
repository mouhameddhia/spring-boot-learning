package tn.esprit.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.demo.entity.Subscription;
import tn.esprit.spring.demo.entity.TypeSubscription;

import java.util.Date;
import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    // Single-object finders
    Subscription findByNumSub(Long numSub);
    Subscription findByTypeSub(TypeSubscription typeSub);

    // List-based finders
    List<Subscription> findByPrice(Float price);
    List<Subscription> findByStartDateBetween(Date start, Date end);
    List<Subscription> findByEndDateBetween(Date start, Date end);

    // Custom query example
    @Query("SELECT s FROM Subscription s WHERE s.price >= :minPrice AND s.price <= :maxPrice")
    List<Subscription> findByPriceRange(@Param("minPrice") Float minPrice, @Param("maxPrice") Float maxPrice);

}
