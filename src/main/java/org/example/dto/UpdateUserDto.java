package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@Data
@With
public class UpdateUserDto {
    String username;
    String password;
    String email;
    String fullName;
    Boolean isAdmin;
}