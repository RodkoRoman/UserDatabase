package org.rodko.userdatabase.service;

import lombok.RequiredArgsConstructor;
import org.rodko.userdatabase.model.entity.BasicAuthEntity;
import org.rodko.userdatabase.repository.BasicAuthRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;


@Service
@RequiredArgsConstructor
public class BasicAuthService {

    private final BasicAuthRepository basicAuthRepository;

    public void auth(String encodedBasicCredentials){
        String[] credentials = new String(Base64.
                getDecoder()
                .decode(encodedBasicCredentials
                        .split(" ")[1])).split(":");
        // 1) строку Х разбили по " " и достали элемент с индексом [1]
        // 2) декодировали этот элемент
        // 3) преобразовали элемент в строку
        // 4) разбили строку по ":" и записали в массив строк

        String username = credentials[0];

        BasicAuthEntity basicAuthEntity = basicAuthRepository.findById(username)
                .orElseThrow();

        if (!credentials[0].equals(basicAuthEntity.getUsername())){
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Пользователь не аутентифицирован! Неверный логин!");
            }
        }
        if (!credentials[1].equals(basicAuthEntity.getPassword())){
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Пользователь не аутентифицирован! Неверный пароль!");
            }
        }
//        Неудачная попытка spring-security
//        if (!credentials[2].equals(basicAuthEntity.getEnable())){
//            try {
//                throw new Exception();
//            } catch (Exception e) {
//                System.out.println("Пользователь не аутентифицирован! Закрыт доступ!");
//            }
//        }

    }

}
