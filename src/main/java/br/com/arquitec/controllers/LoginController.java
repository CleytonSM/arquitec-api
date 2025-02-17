package br.com.arquitec.controllers;

import br.com.arquitec.models.dtos.LoginRequestDTO;
import br.com.arquitec.models.dtos.LoginResponseDTO;
import br.com.arquitec.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/arquinina")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO login) {
        return new ResponseEntity<>(service.login(login), HttpStatus.OK);
    }
}
