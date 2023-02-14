package com.example.assignmentcontest.model.entity;

import com.example.assignmentcontest.model.orther.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Orderr {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private double total_payment;
    private double shipPrice;
    private Status status;
    private String address;
    private String estimate_time;
    private String time_order;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;

    @JsonBackReference
    @OneToMany(mappedBy = "orderr")
    private List<Product> products;
//    public String getTime_order() {
//        return time_order;
//    }
//
//    public void setTime_order(Date creatAt) {
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        this.time_order = dateFormat.format(creatAt);
//    }
}
