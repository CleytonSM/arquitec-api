package br.com.arquitec.controllers;

import br.com.arquitec.models.dtos.RegisterDTO;
import br.com.arquitec.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/arquinina")
public class RegisterController {
    @Autowired
    private RegisterService service;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterDTO register) {
        service.register(register);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
