package com.imalipay.jasperreport;

import lombok.*;
import java.sql.Time;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptData {
    private String recipientName;
    private String receiptNumber;
    private LocalDate receiptDate;
    private Time receiptTime;
    private String phoneNumber;
    private String description;
    private Integer quantity;
    private Double amount;
    private Double total;
    private Double sumTotal;
    private Double amountPaid;
    private Double outstandingBalance;
}
