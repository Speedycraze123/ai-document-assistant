package com.example.aidocumentassistant;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController 
public class DocumentController { 

    private final DocumentService documentService;
    private final PdfService pdfService;

    public DocumentController(PdfService pdfService, DocumentService documentService) {
            this.documentService = documentService;
            this.pdfService = pdfService;
    }

    
    @GetMapping("/api/documents")
    public String getDocuments() {
        return "Document API is Working!";
    }

    @PostMapping("/api/documents")
    public Document uploadDocument(@RequestBody Document document) {
        documentService.addDocument(document);
        return document;
    }

    @GetMapping("/api/documents/test")
    public Document testDocument() {
        return new Document("test-2", "test.pdf", "This is a test document.");
    }

    @GetMapping("/api/documents/service-test")
    public Document getServiceTestDocument() {
        return documentService.getTestDocument();
    }

    @GetMapping("/api/documents/all")
    public Map<String, Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/api/documents/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable String id) {
        Document document = documentService.getDocumentById(id);
        if (document == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(document);
    }

    @DeleteMapping("/api/documents/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable String id) {
        if (documentService.getDocumentById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        documentService.deleteDocument(id);
        return ResponseEntity.ok("Document deleted successfully.");
    }

    @PutMapping("/api/documents/{id}")
    public String updateDocument(@PathVariable String id, @RequestBody Document document) {
        documentService.updateDocument(id, document);
        return "Document updated successfully.";
    }

    @PostMapping ("/api/documents/upload")
    public String uploadDocument(@RequestParam("file") MultipartFile file) throws IOException {
        String extractedText = pdfService.extractText(file);
        return "File uploaded successfully: " + file.getOriginalFilename() + ", Extracted Text: " + extractedText;
    }
}
