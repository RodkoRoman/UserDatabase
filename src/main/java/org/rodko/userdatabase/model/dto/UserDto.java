package org.rodko.userdatabase.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private UUID id;

    @NotNull
    private String lastname;

    @NotNull
    private String firstname;

    @NotNull
    private String patronymic;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private String mail;

    @NotNull
    private String phoneNumber;

    private String addressPhoto;

    public UserDto(String lastname, String firstname, String patronymic, String mail, String phoneNumber) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }
}
