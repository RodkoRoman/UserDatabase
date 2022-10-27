package org.rodko.userdatabase.controller;

import lombok.RequiredArgsConstructor;
import org.rodko.userdatabase.model.dto.UserContactsDto;
import org.rodko.userdatabase.model.dto.UserDto;
import org.rodko.userdatabase.model.entity.UserEntity;
import org.rodko.userdatabase.service.BasicAuthService;
import org.rodko.userdatabase.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BasicAuthService basicAuthService;

    @PostMapping
    public UserEntity createUser(@RequestBody @Valid UserDto userDto,
                                 @RequestHeader(HttpHeaders.AUTHORIZATION) String encodedBasicCredentials) {
        basicAuthService.auth(encodedBasicCredentials);
        return userService.createUser(userDto);
    }

    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable UUID userId,
                           @RequestHeader(HttpHeaders.AUTHORIZATION) String encodedBasicCredentials) {
        basicAuthService.auth(encodedBasicCredentials);
        return userService.getUser(userId);
    }

    @GetMapping
    public List<UserDto> getAllUsers(@RequestHeader(HttpHeaders.AUTHORIZATION) String encodedBasicCredentials) {
        basicAuthService.auth(encodedBasicCredentials);
        return userService.getAllUsers();
    }

    @GetMapping("/contacts/{userId}")
    public UserContactsDto getUserContacts(@PathVariable UUID userId,
                                           @RequestHeader(HttpHeaders.AUTHORIZATION) String encodedBasicCredentials){
        basicAuthService.auth(encodedBasicCredentials);
        return userService.getUserContacts(userId);
    }

    @GetMapping("/contacts")
    public List<UserContactsDto> getAllUsersContacts(@RequestHeader(HttpHeaders.AUTHORIZATION) String encodedBasicCredentials){
        basicAuthService.auth(encodedBasicCredentials);
        return userService.getAllUsersContacts();
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable UUID userId, @RequestBody UserDto userDto,
                           @RequestHeader(HttpHeaders.AUTHORIZATION) String encodedBasicCredentials) {
        basicAuthService.auth(encodedBasicCredentials);
        userService.updateUser(userId, userDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable UUID userId,
                           @RequestHeader(HttpHeaders.AUTHORIZATION) String encodedBasicCredentials) {
        basicAuthService.auth(encodedBasicCredentials);
        userService.deleteUser(userId);
    }
}
