package com.example.aidocumentassistant;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service 
public class DocumentService {
    private Map<String, Document> documents = new HashMap<>();
    
    
    public Document getTestDocument() {
        return new Document("test-2", "service-test.pdf", "This document was created by the service.");
    }

    public void addDocument(Document document) {
        String uniqueId = generateUniqueId();
        document.setId(uniqueId);
        documents.put(uniqueId, document);
    }

    public Map<String, Document> getAllDocuments() {
        return documents;
    }

    public Document getDocumentById(String id) {
        return documents.get(id);
    }

    public void deleteDocument(String id) {
        if (!documents.containsKey(id)) {
            throw new IllegalArgumentException("Document with ID " + id + " does not exist.");
        }
        documents.remove(id);
    }

    public void updateDocument(String id, Document document) {
        if (!documents.containsKey(id)) {
            throw new IllegalArgumentException("Document with ID " + id + " does not exist.");
        }
        documents.put(id, document);
    }

    public String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}
    
