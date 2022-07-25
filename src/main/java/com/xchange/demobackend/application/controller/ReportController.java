package com.xchange.demobackend.application.controller;


import com.lowagie.text.DocumentException;
import com.xchange.demobackend.domain.invoice.InvoiceReportGenerationService;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {


    private InvoiceReportGenerationService invoiceGeneration;

    ReportController(){
        invoiceGeneration = new InvoiceReportGenerationService();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public void export(HttpServletRequest request, HttpServletResponse response) throws IOException{

        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        try {
            invoiceGeneration.renderInvoice().createPDF(out);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        out.close();
    }
}
