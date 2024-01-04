package com.beltrandes.springboot_mongodb.resources;

import com.beltrandes.springboot_mongodb.dto.PostDTO;
import com.beltrandes.springboot_mongodb.services.PostService;
import com.beltrandes.springboot_mongodb.utils.encoders.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        return  ResponseEntity.ok().body(postService.findById(id));
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<PostDTO> posts = postService.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<PostDTO>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
            ) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<PostDTO> posts = postService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(posts);
    }


}
