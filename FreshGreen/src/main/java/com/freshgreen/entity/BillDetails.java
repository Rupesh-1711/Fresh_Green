package com.freshgreen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BillDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer billId;
   
    private Integer orderId;
    
    private String transactionMode;
    
    //  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String transactionDate ;
    
    private String transactionStatus;

//    @Embedded
//    private Address address;




}
