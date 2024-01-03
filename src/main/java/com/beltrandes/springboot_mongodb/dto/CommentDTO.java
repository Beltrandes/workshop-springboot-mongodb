package com.beltrandes.springboot_mongodb.dto;

import java.util.Date;

public record CommentDTO(
        String text,
        Date date,
        AuthorDTO author
) {
}
