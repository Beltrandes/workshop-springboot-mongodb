package com.beltrandes.springboot_mongodb.services;

import com.beltrandes.springboot_mongodb.domain.User;
import com.beltrandes.springboot_mongodb.dto.UserDTO;
import com.beltrandes.springboot_mongodb.repositories.UserRepository;
import com.beltrandes.springboot_mongodb.services.exceptions.ObjectNotFoundException;
import com.beltrandes.springboot_mongodb.utils.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDTO).toList();
    }

    public UserDTO findById(String id) {
        return userMapper.toDTO(userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + id)));
    }
}
