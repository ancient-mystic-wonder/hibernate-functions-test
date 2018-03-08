package com.dtlim.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @Column
    private Long id;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "log_time")
    private String logTime;
}
