package com.beltrandes.springboot_mongodb.repositories;

import com.beltrandes.springboot_mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
