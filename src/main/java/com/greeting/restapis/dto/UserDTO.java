package com.greeting.restapis.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class UserDTO {
    private String firstName;
    private String lastName;
}