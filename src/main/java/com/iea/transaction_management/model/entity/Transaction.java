package com.iea.transaction_management.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@SequenceGenerator(name = "TRANSACTIONS_SEQUENCE", sequenceName = "TRANSACTIONS_SEQ", initialValue = 1, allocationSize = 1)
@Table(name = "TRANSACTIONSS")
@Data
@Entity
public class Transaction
{
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTIONS_SEQUENCE")
    @Column(name = "TRANSACTION_ID")
    @Id
    private Integer transactionID;

    @Column(name = "PRODUCT_ID")
    private Integer productID;

    @Column(name = "USER_ID")
    private Integer userID;

    @Column(name = "TRANSACTION_TIME")
    private Date transactionTime;
}
