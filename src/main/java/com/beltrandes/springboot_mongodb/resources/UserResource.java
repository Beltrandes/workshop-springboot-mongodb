package com.beltrandes.springboot_mongodb.resources;

import com.beltrandes.springboot_mongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        var maria = new User("1", "Maria Brown", "maria@gmail.com");
        var alex = new User("2", "Alex Green", "alex@gmail.com");
        var list = new ArrayList<User>();
        list.addAll(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(list);
    }
}
