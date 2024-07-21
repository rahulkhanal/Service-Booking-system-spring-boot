package service_booking.main.services.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service_booking.main.dto.SignupRequestDTO;
import service_booking.main.dto.UserDto;
import service_booking.main.entities.UserEntity;
import service_booking.main.enums.UserRole;
import service_booking.main.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Override
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

    @Override
    public Boolean presentByEmail(String email) {
        return userRepository.findFirstByEmail(email) != null;
    }

    @Override
    public UserDto signupCompany(SignupRequestDTO body) {
        UserEntity user = new UserEntity();
        user.setName(body.getName());
        user.setEmail(body.getEmail());
        user.setPhone(body.getPhone());
        user.setLastname(body.getLastname());
        user.setPassword(body.getPassword());
        user.setRole(UserRole.COMPANY);
        return userRepository.save(user).getDto();
    }
}
