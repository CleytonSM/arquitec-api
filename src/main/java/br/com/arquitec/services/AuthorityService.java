package br.com.arquitec.services;

import br.com.arquitec.models.entities.Authority;
import br.com.arquitec.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityRepository repository;

    public Authority getCustomerRole() {
        return repository.findById(1).orElse(null);
    }
}
