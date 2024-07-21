package service_booking.main.services.authentication;

import org.springframework.beans.factory.annotation.Autowired;

import service_booking.main.dto.SignupRequestDTO;
import service_booking.main.dto.UserDto;
import service_booking.main.entities.UserEntity;
import service_booking.main.enums.UserRole;
import service_booking.main.repository.UserRepository;

public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    public UserDto signupClient(SignupRequestDTO body) {
        UserEntity user = new UserEntity();
        user.setName(body.getName());
        user.setEmail(body.getEmail());
        user.setPhone(body.getPhone());
        user.setLastname(body.getLastname());
        user.setPassword(body.getPassword());
        user.setRole(UserRole.CLIENT);
        return userRepository.save(user).getDto();
    }
}
