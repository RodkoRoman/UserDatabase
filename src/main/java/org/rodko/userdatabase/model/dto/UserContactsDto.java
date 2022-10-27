package org.rodko.userdatabase.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserContactsDto {

    @NotNull
    private String lastname;

    @NotNull
    private String firstname;

    @NotNull
    private String patronymic;

    @NotNull
    private String mail;

    @NotNull
    private String phoneNumber;


}
