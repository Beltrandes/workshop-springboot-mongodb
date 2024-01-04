package com.beltrandes.springboot_mongodb.repositories;

import com.beltrandes.springboot_mongodb.domain.Post;
import com.beltrandes.springboot_mongodb.dto.PostDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
