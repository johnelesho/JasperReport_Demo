package com.imalipay.jasperreport;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReceiptController {
    private final ReportService service;

    @GetMapping("/report/{format}")
    public String generateReceipt(@PathVariable String format) throws FileNotFoundException, JRException {
        List<ReceiptData> receiptDataList = createSampleReceiptData(); // Create sample receipt data
        return service.exportReceipts(format, receiptDataList);
    }

    private List<ReceiptData> createSampleReceiptData() {
        List<ReceiptData> receiptDataList = new ArrayList<>();
        // Add sample receipt data objects here
        receiptDataList.add(new ReceiptData(
                "Alice Johnson",
                "R12345",
                LocalDate.of(2023, 8, 1),
                Time.valueOf("10:30:00"),
                "555-555-1234",
                "Product A",
                2,
                25.0,
                50.0,
                100.0,
                50.0,
                50.0
        ));
        receiptDataList.add(new ReceiptData(
                "Bob Smith",
                "R56789",
                LocalDate.of(2023, 8, 5),
                Time.valueOf("15:00:00"),
                "555-555-6789",
                "Service B",
                1,
                75.0,
                75.0,
                75.0,
                75.0,
                0.0
        ));


        // Add more sample receipt data objects if needed

        return receiptDataList;
    }
}

