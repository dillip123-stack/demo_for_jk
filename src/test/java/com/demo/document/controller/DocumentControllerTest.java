package com.demo.document.controller;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class DocumentControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    void testIngestDocument() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "doc.txt", "text/plain", "Demo content".getBytes());

        mockMvc.perform(multipart("/documents/ingest")
                        .file(file)
                        .param("title", "Test Title")
                        .param("author", "Test Author")
                        .param("type", "PDF"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Title"))
                .andExpect(jsonPath("$.author").value("Test Author"))
                .andExpect(jsonPath("$.type").value("PDF"));
    }


    @Test
    void testQuestionAnswer() throws Exception {
        mockMvc.perform(post("/documents/qa")
                        .param("keyWord", "test"))
                .andExpect(status().isOk());
    }

    @Test
    void testFilterDocuments() throws Exception {
        mockMvc.perform(get("/documents/filter")
                        .param("author", "Test Author")
                        .param("type", "PDF")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sortBy", "title"))
                .andExpect(status().isOk());

    }
}
