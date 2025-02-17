package br.com.arquitec.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponseDTO {
    private Integer userId;
    private String token;
    private String name;
    private String lastname;
    private String email;
}
