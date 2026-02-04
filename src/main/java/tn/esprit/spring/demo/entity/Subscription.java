package tn.esprit.spring.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "subscription")
@NoArgsConstructor
@AllArgsConstructor
@Builder  // Lombok builder
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_sub")
    private Long numSub;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "price")
    private Float price;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_sub")
    private TypeSubscription typeSub;


    // Getters and Setters
    public Long getNumSub() {
        return numSub;
    }

    public void setNumSub(Long numSub) {
        this.numSub = numSub;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public TypeSubscription getTypeSub() {
        return typeSub;
    }

    public void setTypeSub(TypeSubscription typeSub) {
        this.typeSub = typeSub;
    }
}
