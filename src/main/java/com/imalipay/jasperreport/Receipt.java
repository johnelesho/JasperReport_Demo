package com.imalipay.jasperreport;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "receipt_tbl")
@Getter
@Setter
@Data
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String description;
    private Integer quantity;
    private Double amount;
    private Double total;

}

