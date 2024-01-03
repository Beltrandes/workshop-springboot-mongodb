package com.beltrandes.springboot_mongodb.dto;

import java.util.Date;
import java.util.List;

public record PostDTO(
        String id,
        Date date,
        String title,
        String body,
        AuthorDTO author,
        List<CommentDTO> comments
) {
}
