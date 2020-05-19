package com.brianedwards.springbootsecurity.Repository;

import com.brianedwards.springbootsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEidmUserIdIgnoreCase(String eidmUserId);
}
