package com.example.aidocumentassistant;

public class Document {
    private String id;
    private String fileName;
    private String content;

    public Document(String id, String fileName, String content) {
        this.id = id;
        this.fileName = fileName;
        this.content = content;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
