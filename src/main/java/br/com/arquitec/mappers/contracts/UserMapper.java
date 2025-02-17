package br.com.arquitec.mappers.contracts;

import br.com.arquitec.models.dtos.RegisterDTO;
import br.com.arquitec.models.dtos.UserUpdateDTO;
import br.com.arquitec.models.entities.User;

public interface UserMapper {
    User mapRegisterDTOtoUser(RegisterDTO register);

    User mapUserUpdateDTOToUser(User user, UserUpdateDTO userUpdate);
}
