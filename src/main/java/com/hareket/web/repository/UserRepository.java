package com.hareket.web.repository;

import com.hareket.web.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT a FROM User a WHERE a.code=:code and a.password=:password and a.typ = 1")
    User checkLogin(@Param("code") String code, @Param("password") String password);
}
