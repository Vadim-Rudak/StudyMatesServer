package org.example.bookfd.repos;

import org.example.bookfd.domain.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepo extends JpaRepository<Auth,Long> {
    Auth findByLogin(String login);
}
