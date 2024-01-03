package com.beltrandes.springboot_mongodb.dto;

import com.beltrandes.springboot_mongodb.domain.Post;
import org.apache.catalina.User;

import java.util.List;

public record UserDTO(
        String id,
        String name,
        String email,
        List<Post> posts
) {



}
