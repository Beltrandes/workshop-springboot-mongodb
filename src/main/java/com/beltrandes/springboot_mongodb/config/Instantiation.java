package com.beltrandes.springboot_mongodb.config;

import com.beltrandes.springboot_mongodb.domain.Post;
import com.beltrandes.springboot_mongodb.domain.User;
import com.beltrandes.springboot_mongodb.repositories.PostRepository;
import com.beltrandes.springboot_mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        var maria = new User(null, "Maria Brown", "maria@gmail.com");
        var alex = new User(null, "Alex Green", "alex@gmail.com");
        var bob = new User(null, "Bob Grey", "bob@gmail.com");

        var post1 = new Post(null, sdf.parse("20/10/2023"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        var post2 = new Post(null, sdf.parse("21/10/2023"), "Bom dia", "Acordei feliz hoje!", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));


    }
}
