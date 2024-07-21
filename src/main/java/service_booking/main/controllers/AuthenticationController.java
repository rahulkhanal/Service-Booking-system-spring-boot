package service_booking.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service_booking.main.dto.SignupRequestDTO;
import service_booking.main.dto.UserDto;
import service_booking.main.services.authentication.AuthService;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupClient(@RequestBody SignupRequestDTO body, @RequestParam("user") String userType) {
        if (authService.presentByEmail(body.getEmail())) {
            return new ResponseEntity<>("Client already exist with that mail", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdUser;
        if ("company".equalsIgnoreCase(userType)) {
            createdUser = authService.signupCompany(body);
        } else if ("client".equalsIgnoreCase(userType)) {
            createdUser = authService.signupClient(body);
        } else {
            return new ResponseEntity<>("Invalid user type", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }
}
