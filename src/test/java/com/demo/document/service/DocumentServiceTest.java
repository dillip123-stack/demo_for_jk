package com.demo.document.service;

import com.demo.document.dao.DocumentRepository;
import com.demo.document.dto.DocumentResponse;
import com.demo.document.entity.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import org.springframework.mock.web.MockMultipartFile;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DocumentServiceTest {
    private DocumentRepository documentRepository;
    private DocumentService documentService;

    @BeforeEach
    void setUp() {
        documentRepository = mock(DocumentRepository.class);
        documentService = new DocumentService(documentRepository);
    }

    @Test
    void testQuestionAnswer() {
        Document doc = new Document(1L, "Doc1", "Author", "txt", "keyword content", LocalDate.now());
        when(documentRepository.searchByKeyword("keyword")).thenReturn(List.of(doc));

        List<DocumentResponse> result = documentService.questionAnswer("keyword");

        assertEquals(1, result.size());
        assertEquals("Doc1", result.get(0).getTitle());
    }

    @Test
    void testUploadAndIngest_plainText() throws Exception {
        String text = "This is a plain text file";
        MockMultipartFile file = new MockMultipartFile("file", "text.txt", "text/plain", text.getBytes());

        ArgumentCaptor<Document> captor = ArgumentCaptor.forClass(Document.class);
        when(documentRepository.save(any())).thenAnswer(i -> {
            Document d = i.getArgument(0);
            d.setId(1L);
            return d;
        });

        DocumentResponse response = documentService.uploadAndIngest(file, "Plain Text", "Tester", "txt");

        verify(documentRepository).save(captor.capture());
        assertEquals("Plain Text", captor.getValue().getTitle());
        assertEquals("Tester", captor.getValue().getAuthor());
        assertEquals(text, captor.getValue().getContent());
        assertEquals("Plain Text", response.getTitle());
    }

    @Test
    void testUploadAndIngest_pdf() throws Exception {
        ByteArrayInputStream pdfStream = new ByteArrayInputStream(
                "%PDF-1.4\n%âãÏÓ\n1 0 obj\n<<\n>>\nendobj\ntrailer\n<<>>\n%%EOF".getBytes()
        );
        MockMultipartFile file = new MockMultipartFile("file", "sample.pdf", "application/pdf", pdfStream);
        assertThrows(Exception.class, () -> {
            documentService.uploadAndIngest(file, "PDF Doc", "PDF Tester", "pdf");
        });
    }

    @Test
    void testUploadAndIngest_docx() throws Exception {
        XWPFDocument doc = new XWPFDocument();
        doc.createParagraph().createRun().setText("Docx content");
        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[0]);
        try (var out = new java.io.ByteArrayOutputStream()) {
            doc.write(out);
            bais = new ByteArrayInputStream(out.toByteArray());
        }

        MockMultipartFile file = new MockMultipartFile("file", "test.docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", bais);

        when(documentRepository.save(any())).thenAnswer(i -> {
            Document d = i.getArgument(0);
            d.setId(3L);
            return d;
        });

        DocumentResponse response = documentService.uploadAndIngest(file, "DOCX Title", "Docx Author", "docx");

        assertEquals("DOCX Title", response.getTitle());
        assertEquals("Docx Author", response.getAuthor());
    }

    @Test
    void testFilter() {
        Document doc1 = new Document(1L, "Doc1", "Author", "pdf", "content", LocalDate.now());
        Document doc2 = new Document(2L, "Doc2", "Author", "pdf", "content", LocalDate.now());

        Pageable pageable = PageRequest.of(0, 2, Sort.by("title"));
        Page<Document> docPage = new PageImpl<>(List.of(doc1, doc2), pageable, 2);

        when(documentRepository.findByAuthorContainingIgnoreCaseAndTypeContainingIgnoreCase("Author", "pdf", pageable))
                .thenReturn(docPage);

        Page<DocumentResponse> response = documentService.filter("Author", "pdf", 0, 2, "title");

        assertEquals(2, response.getContent().size());
        assertEquals("Doc1", response.getContent().get(0).getTitle());
    }
}
