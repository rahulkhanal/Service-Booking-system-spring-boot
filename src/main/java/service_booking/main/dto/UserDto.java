package service_booking.main.dto;

import lombok.Data;
import service_booking.main.enums.UserRole;

@Data
public class UserDto {
    private Long id;

    private String email;
    private String password;
    private String name;
    private String lastname;
    private String phone;
    private UserRole role;
}
