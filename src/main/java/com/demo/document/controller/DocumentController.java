package com.demo.document.controller;

import com.demo.document.dto.DocumentResponse;
import com.demo.document.service.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/documents")
@Tag(name = "Document Controller", description = "APIs for document ingestion and retrieval")
public class DocumentController {
    @Autowired
    private final DocumentService documentService;

    DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @Operation(summary = "Upload and ingest a document")
    @PostMapping("/ingest")
    public ResponseEntity<DocumentResponse> ingest(@RequestParam("file") MultipartFile file,
                                                   @RequestParam("title") String title,
                                                   @RequestParam("author") String author,
                                                   @RequestParam("type") String type) {
        try {
            return ResponseEntity.ok(documentService.uploadAndIngest(file, title, author, type));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Post question in key word")
    @PostMapping("/qa")
    public ResponseEntity<List<DocumentResponse>> qa(@RequestParam String keyWord) {
        return ResponseEntity.ok(documentService.questionAnswer(keyWord));
    }

    @Operation(summary = "Filtering the document")
    @GetMapping("/filter")
    public ResponseEntity<Page<DocumentResponse>> filter(
            @RequestParam(defaultValue = "") String author,
            @RequestParam(defaultValue = "") String type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "title") @Parameter(name = "sortBy", description = "Must be title or author or type")String sortBy) {
        return ResponseEntity.ok(documentService.filter(author, type, page, size, sortBy));
    }
}
