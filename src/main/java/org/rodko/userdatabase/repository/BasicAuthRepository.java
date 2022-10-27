package org.rodko.userdatabase.repository;

import org.rodko.userdatabase.model.entity.BasicAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BasicAuthRepository extends JpaRepository<BasicAuthEntity, String> {
}
