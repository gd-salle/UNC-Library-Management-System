package org.unc.lms.codes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unc.lms.codes.services.PdfGenerationService;

@RestController
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private PdfGenerationService pdfGenerationService;

    @GetMapping("/generate")
    public String generatePdf() {
        pdfGenerationService.generatePdf();
        return "PDF generated successfully!";
    }
}

