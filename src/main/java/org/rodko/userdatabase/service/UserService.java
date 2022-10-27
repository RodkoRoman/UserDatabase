package org.rodko.userdatabase.service;


import lombok.RequiredArgsConstructor;
import org.rodko.userdatabase.model.dto.UserContactsDto;
import org.rodko.userdatabase.model.dto.UserDto;
import org.rodko.userdatabase.model.entity.UserEntity;
import org.rodko.userdatabase.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserEntity createUser(UserDto userDto) {
        return userRepository.save(
                new UserEntity(
                        UUID.randomUUID(),
                        userDto.getFirstname(),
                        userDto.getLastname(),
                        userDto.getPatronymic(),
                        userDto.getDateOfBirth(),
                        userDto.getMail(),
                        userDto.getPhoneNumber(),
                        userDto.getAddressPhoto()
                )
        );
    }

    public UserDto getUser(UUID userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow();

        return new UserDto(
                userEntity.getId(),
                userEntity.getFirstname(),
                userEntity.getLastname(),
                userEntity.getPatronymic(),
                userEntity.getDateOfBirth(),
                userEntity.getMail(),
                userEntity.getPhoneNumber(),
                userEntity.getAddressPhoto()
        );
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        List<UserEntity> userEntityList = userRepository.findAll();
        for (UserEntity user : userEntityList) {
            userDtoList.add(new UserDto(
                    user.getId(),
                    user.getFirstname(),
                    user.getLastname(),
                    user.getPatronymic(),
                    user.getDateOfBirth(),
                    user.getMail(),
                    user.getPhoneNumber(),
                    user.getAddressPhoto()
            ));
        }
        return userDtoList;
    }

    public UserContactsDto getUserContacts(UUID userId){
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow();

        return new UserContactsDto(
                userEntity.getLastname(),
                userEntity.getFirstname(),
                userEntity.getPatronymic(),
                userEntity.getMail(),
                userEntity.getPhoneNumber()
        );
    }

    public List<UserContactsDto> getAllUsersContacts(){
        List<UserContactsDto> userDtoList = new ArrayList<>();
        List<UserEntity> userEntityList = userRepository.findAll();

        for (UserEntity user : userEntityList) {
            userDtoList.add(new UserContactsDto(
                    user.getLastname(),
                    user.getFirstname(),
                    user.getPatronymic(),
                    user.getMail(),
                    user.getPhoneNumber()
            ));
        }
        return userDtoList;
    }

    @Transactional
    public void updateUser(UUID userId, UserDto userDto) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow();
        if (userDto.getFirstname() != null) {
            userEntity.setFirstname(userDto.getFirstname());
        }
        if (userDto.getLastname() != null) {
            userEntity.setLastname(userDto.getLastname());
        }
        if (userDto.getPatronymic() != null) {
            userEntity.setPatronymic(userDto.getPatronymic());
        }
        if (userDto.getDateOfBirth() != null) {
            userEntity.setDateOfBirth(userDto.getDateOfBirth());
        }
        if (userDto.getMail() != null) {
            userEntity.setMail(userDto.getMail());
        }
        if (userDto.getPhoneNumber() != null) {
            userEntity.setPhoneNumber(userDto.getPhoneNumber());
        }
        if (userDto.getAddressPhoto() != null) {
            userEntity.setAddressPhoto(userDto.getAddressPhoto());
        }
        userRepository.save(userEntity);
    }

    @Transactional
    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }
}
