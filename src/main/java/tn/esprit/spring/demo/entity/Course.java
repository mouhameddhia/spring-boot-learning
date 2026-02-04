package tn.esprit.spring.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Builder  // Lombok builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_course")
    private Long numCourse;

    @Column(name = "level")
    private int level;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_course")
    private TypeCourse typeCourse;

    @Enumerated(EnumType.STRING)
    @Column(name = "support")
    private Support support;

    @Column(name = "price")
    private Float price;

    @Column(name = "time_slot")
    private int timeSlot;



    // Getters and Setters
    public Long getNumCourse() {
        return numCourse;
    }

    public void setNumCourse(Long numCourse) {
        this.numCourse = numCourse;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public TypeCourse getTypeCourse() {
        return typeCourse;
    }

    public void setTypeCourse(TypeCourse typeCourse) {
        this.typeCourse = typeCourse;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }
}