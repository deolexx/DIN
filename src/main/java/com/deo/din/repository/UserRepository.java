package com.deo.din.repository;

import com.deo.din.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

  User findByUsername(String username);

}
