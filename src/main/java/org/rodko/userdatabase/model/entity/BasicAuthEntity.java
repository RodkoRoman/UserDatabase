package org.rodko.userdatabase.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BasicAuthEntity {

    @Id
    @Column
    private String username;

    @Column
    private String password;

}
