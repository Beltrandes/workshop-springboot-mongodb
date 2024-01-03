package com.beltrandes.springboot_mongodb.utils.mappers;

import com.beltrandes.springboot_mongodb.domain.User;
import com.beltrandes.springboot_mongodb.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toDTO(User entity) {
        return new UserDTO(entity.getId(), entity.getName(), entity.getEmail());
    }
    public User toEntity(UserDTO dto) {
        return new User(dto.id(),dto.name(), dto.email());
    }
}
