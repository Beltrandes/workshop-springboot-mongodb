package com.beltrandes.springboot_mongodb.utils.mappers;

import com.beltrandes.springboot_mongodb.domain.User;
import com.beltrandes.springboot_mongodb.dto.AuthorDTO;
import com.beltrandes.springboot_mongodb.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public AuthorDTO toDTO(User user) {
        return new AuthorDTO(user.getId(), user.getName());
    }
    }
