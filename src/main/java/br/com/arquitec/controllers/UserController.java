package br.com.arquitec.controllers;

import br.com.arquitec.models.dtos.UserUpdateDTO;
import br.com.arquitec.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/arquinina/user")
public class UserController {
    @Autowired
    private UserService service;

    @PutMapping("/update")
    public ResponseEntity<Void> update(HttpServletRequest request, @RequestBody UserUpdateDTO user) {
        service.update(request, user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
