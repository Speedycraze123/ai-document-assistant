package com.example.aidocumentassistant;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

public class PdfServiceTest {

    @Test 
    public void shouldExtractTextFromPdf() throws IOException {
        File pdfFile = new File("src/main/resources/sample.pdf");
        MultipartFile multipartFile = new MockMultipartFile("file", pdfFile.getName(), "application/pdf", Files.readAllBytes(pdfFile.toPath()));
        PdfService pdfService = new PdfService();
        String extractedText = pdfService.extractText(multipartFile);
        assertEquals("This is my first PDF extraction test. The AI Document Assistant is working!", extractedText.trim());
    }
    
}
