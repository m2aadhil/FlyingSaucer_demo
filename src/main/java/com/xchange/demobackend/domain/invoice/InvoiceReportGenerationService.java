package com.xchange.demobackend.domain.invoice;

import com.xchange.demobackend.domain.invoice.dto.Product;
import com.xchange.demobackend.platform.report.ReportBuilder;
import java.util.ArrayList;
import java.util.List;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class InvoiceReportGenerationService {


    private ReportBuilder reportBuilder;

    public InvoiceReportGenerationService(){
        this.reportBuilder = new ReportBuilder();
    }

    public ITextRenderer renderInvoice(){

        Context context = new Context();

        //setting template variables
        context.setVariable("invoice", "3906_2022-03_08");
        context.setVariable("prods", getDummyProducts());

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(reportBuilder.parseReport("invoice_template", context));
        renderer.layout();

        return renderer;
    }

    private List<Product> getDummyProducts(){
        List<Product> products = new ArrayList();
        for(int i=0; i < 10; i++){
            products.add(new Product("Test", 12.34, "Yes"));
            products.add(new Product("AAdhokl", 12.34, "False"));
            products.add(new Product("Tes2t", 121212.34, "Yes"));
            products.add(new Product("Tes3t", 12.34222, "False"));
            products.add(new Product("Test1213", 11.34, "False"));
            products.add(new Product("Tes1t", 1212.3412, "Yes"));
        }
        return products;
    }
}
