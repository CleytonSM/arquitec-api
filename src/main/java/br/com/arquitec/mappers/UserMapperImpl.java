package br.com.arquitec.mappers;

import br.com.arquitec.mappers.contracts.UserMapper;
import br.com.arquitec.models.dtos.RegisterDTO;
import br.com.arquitec.models.dtos.UserUpdateDTO;
import br.com.arquitec.models.entities.Authority;
import br.com.arquitec.models.entities.User;
import br.com.arquitec.models.enums.Role;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User mapRegisterDTOtoUser(RegisterDTO register) {
        return User.builder()
                .active(false)
                .name(register.getName())
                .lastname(register.getLastname())
                .email(register.getEmail())
                .password(register.getPassword())
                .active(false)
                .isFullyCreated(false)
                .createdAt(LocalDateTime.now())
                .build();
    }

    @Override
    public User mapUserUpdateDTOToUser(User user, UserUpdateDTO userUpdate) {
        user.setName(userUpdate.getName());
        user.setLastname(userUpdate.getLastname());
        user.setEmail(userUpdate.getEmail());

        return user;
    }
}
