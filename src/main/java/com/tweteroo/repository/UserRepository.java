package com.tweteroo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

  Optional<User> findUserByUsername (String username);
}
