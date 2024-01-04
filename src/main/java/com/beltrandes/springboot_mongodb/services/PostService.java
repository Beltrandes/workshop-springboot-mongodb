package com.beltrandes.springboot_mongodb.services;

import com.beltrandes.springboot_mongodb.dto.PostDTO;
import com.beltrandes.springboot_mongodb.repositories.PostRepository;
import com.beltrandes.springboot_mongodb.services.exceptions.ObjectNotFoundException;
import com.beltrandes.springboot_mongodb.utils.mappers.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostMapper postMapper;

    public PostDTO findById(String id) {
        return postMapper.toDTO(postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + id)));
    }

    public List<PostDTO> findByTitle(String text) {
        return postRepository.searchTitle(text).stream().map(postMapper::toDTO).toList();
    }

    public List<PostDTO> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate).stream().map(postMapper::toDTO).toList();
    }
}
