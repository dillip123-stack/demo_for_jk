package com.demo.document.mapper;

import com.demo.document.dto.DocumentResponse;
import com.demo.document.entity.Document;

public class Mapper {
    public static DocumentResponse toResponse(Document doc) {
        return new DocumentResponse(
                doc.getId(),
                doc.getTitle(),
                doc.getAuthor(),
                doc.getType(),
                doc.getContent(),
                doc.getCreatedDate()
        );
    }
}
