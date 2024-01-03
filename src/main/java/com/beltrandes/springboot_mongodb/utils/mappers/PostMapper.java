package com.beltrandes.springboot_mongodb.utils.mappers;

import com.beltrandes.springboot_mongodb.domain.Post;
import com.beltrandes.springboot_mongodb.dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public PostDTO toDTO(Post post) {
        return new PostDTO(post.getId(), post.getDate(), post.getTitle(), post.getBody(), post.getAuthor(), post.getComments());
    }

    public Post toEntity(PostDTO dto) {
        var post = new Post();
        post.setId(dto.id());
        post.setDate(dto.date());
        post.setTitle(dto.title());
        post.setBody(dto.body());
        post.setAuthor(dto.author());
        post.setComments(dto.comments());
        return post;
    }
}
