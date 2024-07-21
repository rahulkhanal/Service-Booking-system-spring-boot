package service_booking.main.services.authentication;

import service_booking.main.dto.SignupRequestDTO;
import service_booking.main.dto.UserDto;

public interface AuthService {
    UserDto signupClient(SignupRequestDTO body);

    Boolean presentByEmail(String email);

    UserDto signupCompany(SignupRequestDTO body);

}
