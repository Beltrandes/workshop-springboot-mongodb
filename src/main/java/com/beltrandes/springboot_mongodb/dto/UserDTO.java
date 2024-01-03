package com.beltrandes.springboot_mongodb.dto;

import org.apache.catalina.User;

public record UserDTO(
        String id,
        String name,
        String email
) {



}
