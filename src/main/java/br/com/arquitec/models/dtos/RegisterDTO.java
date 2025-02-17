package br.com.arquitec.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDTO {
    private String name;
    private String lastname;
    private String email;
    private String password;
}
