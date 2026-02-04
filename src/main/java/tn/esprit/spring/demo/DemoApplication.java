package tn.esprit.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import tn.esprit.spring.demo.entity.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner testEntities() {
        return args -> {
            log.info("🔧 Starting entity tests...");

            try {
                // Test 1: Piste
                Piste piste = Piste.builder()
                        .namePiste("Blue Diamond")
                        .color(Color.valueOf("Blue"))
                        .length(5000)
                        .slope(15)
                        .build();
                log.info("✅ Piste created: {}", piste.getNamePiste());

                // Test 2: Skier
                Date dob = new SimpleDateFormat("yyyy-MM-dd").parse("1995-05-15");
                Skier skier = Skier.builder()
                        .firstname("John")
                        .lastname("Doe")
                        .dateOfBirth(dob)
                        .city("Chamonix")
                        .build();
                log.info("✅ Skier created: {} {}", skier.getFirstname(), skier.getLastname());

                // Test 3: Instructor
                Instructor instructor = Instructor.builder()
                        .firstName("Marie")
                        .lastName("Martin")
                        .dateOfHire(new Date())
                        .build();
                log.info("✅ Instructor created: {} {}", instructor.getFirstName(), instructor.getLastName());

                // Test 4: Course
                Course course = Course.builder()
                        .level(2)
                        .typeCourse(TypeCourse.Collective_Adult)
                        .support(Support.Ski)
                        .price(120.50f)
                        .timeSlot(10)
                        .build();
                log.info("✅ Course created: Level {} - {}", course.getLevel(), course.getTypeCourse());

                // Test 5: Subscription
                Date endDate = new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000);
                Subscription subscription = Subscription.builder()
                        .startDate(new Date())
                        .endDate(endDate)
                        .price(299.99f)
                        .typeSub(TypeSubscription.Monhly)
                        .build();

                // Warning: Check if subscription price is high
                if (subscription.getPrice() > 200) {
                    log.warn("⚠️ High subscription price detected: {}€", subscription.getPrice());
                }
                log.info("✅ Subscription created: {}", subscription.getTypeSub());

                // Test 6: Registration
                Registration registration = Registration.builder()
                        .numWeek(15)
                        .build();
                log.info("✅ Registration created for week: {}", registration.getNumWeek());

                // Warning: Check registration week
                if (registration.getNumWeek() > 52) {
                    log.warn("⚠️ Invalid week number: {}", registration.getNumWeek());
                }

                // Test constructors
                Piste emptyPiste = new Piste();
                emptyPiste.setNamePiste("Test Piste");
                log.info("✅ Empty piste created and modified");

                // Simulate an error scenario
                simulateErrorScenario();

                log.info("==============================================");
                log.info("✅ All tests completed successfully!");
                log.info("📊 Entities created: 7");

            } catch (Exception e) {
                log.error("❌ Error during entity testing: {}", e.getMessage(), e);
            }
        };
    }

    private void simulateErrorScenario() {
        try {
            // Simulate a potential error
            log.info("Testing error scenario...");

            // This will throw IllegalArgumentException
            Color invalidColor = Color.valueOf("INVALID_COLOR");

        } catch (IllegalArgumentException e) {
            log.error("❌ Invalid color value provided!", e);
            log.warn("⚠️ Using default color instead");

            // Continue with default
            Color defaultColor = Color.valueOf("Blue");
            log.info("Using default color: {}", defaultColor);
        }

        // Another warning example
        Course expensiveCourse = Course.builder()
                .price(500.0f)
                .level(1)
                .typeCourse(TypeCourse.Individual)
                .support(Support.Ski)
                .timeSlot(9)
                .build();

        if (expensiveCourse.getPrice() > 300) {
            log.warn("⚠️ Expensive course detected: {}€ for level {}",
                    expensiveCourse.getPrice(), expensiveCourse.getLevel());
        }

        // Check for unusual time slot
        if (expensiveCourse.getTimeSlot() < 8 || expensiveCourse.getTimeSlot() > 18) {
            log.error("❌ Invalid time slot: {}", expensiveCourse.getTimeSlot());
        }
    }
}