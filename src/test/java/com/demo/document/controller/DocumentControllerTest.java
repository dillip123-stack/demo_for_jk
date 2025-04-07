package com.demo.document.controller;

import com.demo.document.dto.DocumentResponse;
import com.demo.document.service.DocumentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DocumentControllerTest {
    @InjectMocks
    DocumentController documentController;
    @Mock
    DocumentService documentService;

    @Test
    void ingest_shouldReturnOkResponse_whenDocumentIsUploaded() throws IOException {
        MockMultipartFile file = new MockMultipartFile(
                "file", "test.txt", "text/plain", "Sample content".getBytes());

        DocumentResponse mockResponse = new DocumentResponse();
        mockResponse.setId(1L);
        mockResponse.setTitle("Test");
        mockResponse.setAuthor("Author");
        mockResponse.setType("txt");
        mockResponse.setContent("content");
        mockResponse.setCreatedDate(LocalDate.now());

        when(documentService.uploadAndIngest(file, "Test", "Author", "txt")).thenReturn(mockResponse);

        ResponseEntity<DocumentResponse> response = documentController.ingest(file, "Test", "Author", "txt");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getId());
        assertEquals("Test", response.getBody().getTitle());
        assertEquals("Author", response.getBody().getAuthor());
        assertEquals("txt", response.getBody().getType());
        assertEquals("content", response.getBody().getContent());
        assertEquals(LocalDate.now(), response.getBody().getCreatedDate());
    }

    @Test
    void ingest_shouldReturnInternalServerError_whenIOExceptionThrown() throws IOException {
        MockMultipartFile file = new MockMultipartFile(
                "file", "badfile.txt", "text/plain", "broken".getBytes());

        when(documentService.uploadAndIngest(file, "Bad", "NoOne", "txt")).thenThrow(new IOException("Simulated failure"));

        ResponseEntity<DocumentResponse> response = documentController.ingest(file, "Bad", "NoOne", "txt");

        assertEquals(500, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    void qa_shouldReturnDocumentList_whenKeywordIsValid() {
        String keyword = "AI";

        DocumentResponse doc1 = new DocumentResponse();
        doc1.setTitle("AI in Healthcare");
        doc1.setAuthor("Dr. Dillip");
        doc1.setType("pdf");

        DocumentResponse doc2 = new DocumentResponse();
        doc2.setTitle("Future of AI");
        doc2.setAuthor("Deepak Das");
        doc2.setType("docx");

        List<DocumentResponse> mockResponse = Arrays.asList(doc1, doc2);
        when(documentService.questionAnswer(keyword)).thenReturn(mockResponse);

        ResponseEntity<List<DocumentResponse>> response = documentController.qa(keyword);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        assertEquals("AI in Healthcare", response.getBody().get(0).getTitle());
    }

    @Test
    void filter_shouldReturnFilteredPage_whenParamsAreValid() {
        String author = "Dillip";
        String type = "pdf";
        int page = 0;
        int size = 5;
        String sortBy = "title";

        DocumentResponse doc = new DocumentResponse();
        doc.setTitle("Doc1");
        doc.setAuthor("Dillip");
        doc.setType("pdf");

        Page<DocumentResponse> mockPage = new PageImpl<>(List.of(doc));
        when(documentService.filter(author, type, page, size, sortBy)).thenReturn(mockPage);

        ResponseEntity<Page<DocumentResponse>> response = documentController.filter(author, type, page, size, sortBy);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().getContent().size());
        assertEquals("Doc1", response.getBody().getContent().get(0).getTitle());
    }
}
