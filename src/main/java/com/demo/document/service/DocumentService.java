package com.demo.document.service;

import com.demo.document.dao.DocumentRepository;
import com.demo.document.dto.DocumentResponse;
import com.demo.document.entity.Document;
import com.demo.document.mapper.Mapper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }


    public List<DocumentResponse> questionAnswer(String keyword) {
        return documentRepository.searchByKeyword(keyword).stream()
                .map(Mapper::toResponse)
                .collect(Collectors.toList());
    }

    public DocumentResponse uploadAndIngest(MultipartFile file, String title, String author, String type) throws IOException {
        String content = extractTextFromFile(file);
        Document doc = new Document();
        doc.setTitle(title);
        doc.setAuthor(author);
        doc.setType(type);
        doc.setContent(content);
        doc.setCreatedDate(LocalDate.now());

        return Mapper.toResponse(documentRepository.save(doc));
    }

    private String extractTextFromFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename().toLowerCase();
        try (InputStream inputStream = file.getInputStream()) {
            if (fileName.endsWith(".pdf")) {
                try (PDDocument pdf = PDDocument.load(inputStream)) {
                    PDFTextStripper stripper = new PDFTextStripper();
                    return stripper.getText(pdf);
                }
            } else if (fileName.endsWith(".docx")) {
                try (XWPFDocument docx = new XWPFDocument(inputStream)) {
                    XWPFWordExtractor extractor = new XWPFWordExtractor(docx);
                    return extractor.getText();
                }
            } else {
                return new String(file.getBytes());
            }
        }
    }

    public Page<DocumentResponse> filter(String author, String type, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return documentRepository.findByAuthorContainingIgnoreCaseAndTypeContainingIgnoreCase(author, type, pageable)
                .map(Mapper::toResponse);
    }


}
