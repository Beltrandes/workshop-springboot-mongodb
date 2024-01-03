package com.beltrandes.springboot_mongodb.config;

import com.beltrandes.springboot_mongodb.domain.Post;
import com.beltrandes.springboot_mongodb.domain.User;
import com.beltrandes.springboot_mongodb.dto.AuthorDTO;
import com.beltrandes.springboot_mongodb.dto.CommentDTO;
import com.beltrandes.springboot_mongodb.repositories.PostRepository;
import com.beltrandes.springboot_mongodb.repositories.UserRepository;
import com.beltrandes.springboot_mongodb.utils.mappers.AuthorMapper;
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

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        var maria = new User(null, "Maria Brown", "maria@gmail.com");
        var alex = new User(null, "Alex Green", "alex@gmail.com");
        var bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        var post1 = new Post(null, sdf.parse("20/10/2023"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", authorMapper.toDTO(maria));
        var post2 = new Post(null, sdf.parse("21/10/2023"), "Bom dia", "Acordei feliz hoje!", authorMapper.toDTO(maria));

        var c1 = new CommentDTO("Boa viagem mano!", sdf.parse("20/03/2023"), authorMapper.toDTO(alex));
        var c2 = new CommentDTO("Aproveite", sdf.parse("20/03/2023"), authorMapper.toDTO(bob));
        var c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("21/03/2023"), authorMapper.toDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(maria);
    }
}
