package br.com.arquitec.services;

import br.com.arquitec.mappers.UserMapperImpl;
import br.com.arquitec.models.dtos.RegisterDTO;
import br.com.arquitec.models.dtos.UserUpdateDTO;
import br.com.arquitec.models.entities.User;
import br.com.arquitec.repositories.UserRepository;
import br.com.arquitec.securities.jwt.JwtExtractor;
import br.com.arquitec.validators.NewUserValidator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserMapperImpl userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private JwtExtractor jwtExtractor;

    public User create(RegisterDTO register) {
        User newUser = userMapper.mapRegisterDTOtoUser(register);
        NewUserValidator.validateIfAlreadyExists(repository.findByEmail(newUser.getEmail()).isPresent());

        newUser.setAuthority(authorityService.getCustomerRole());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        return save(newUser);
    }

    public void update(HttpServletRequest request, UserUpdateDTO userUpdate) {
        User user = getById(extractIdFromRequest(request));
        if(!user.getEmail().equals(userUpdate.getEmail())) {
            NewUserValidator.validateIfAlreadyExists(repository.findByEmail(userUpdate.getEmail()).isPresent());
            user.setActive(Boolean.FALSE);
        }

        user = userMapper.mapUserUpdateDTOToUser(user, userUpdate);

        save(user);
    }

    public User getById(Integer id) {
        return findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    private User save(User user) {
        return repository.save(user);
    }

    public User getByEmail(String email) {
        return findByEmail(email).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    private Optional<User> findById(Integer id) {
        return repository.findById(id);
    }

    private Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    private Integer extractIdFromRequest(HttpServletRequest request) {
        System.out.println(jwtExtractor.extractUserId(request.getHeader("Authorization")));
        return Integer.parseInt(jwtExtractor.extractUserId(request.getHeader("Authorization")));
    }
}
