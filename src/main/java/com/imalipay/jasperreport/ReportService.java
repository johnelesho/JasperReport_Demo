package com.imalipay.jasperreport;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportService {

    public String exportReceipts(String receiptFormat, List<ReceiptData> receiptDataList) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\PC\\Documents\\Report";
        File file = ResourceUtils.getFile("classpath:receipt.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        for (ReceiptData receiptData : receiptDataList) {
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(List.of(receiptData)); // Create a list with one element
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "Fortune");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            String fileName = "receipt_" + receiptData.getRecipientName() + "." + receiptFormat;
            if (receiptFormat.equalsIgnoreCase("html")) {
                JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\" + fileName);
            }
            if (receiptFormat.equalsIgnoreCase("pdf")) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\" + fileName);
            }
        }

        return "Receipt generated in path: " + path;
    }
}
