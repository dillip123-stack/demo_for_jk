package com.demo.document.dto;

import java.time.LocalDate;

public class DocumentResponse {
    private Long id;
    private String title;
    private String author;
    private String type;
    private String content;
    private LocalDate createdDate;

    public DocumentResponse() {
    }

    public DocumentResponse(Long id, String title, String author, String type, String content, LocalDate createdDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.type = type;
        this.content = content;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
