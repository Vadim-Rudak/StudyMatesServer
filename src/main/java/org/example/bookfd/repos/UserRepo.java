package org.example.bookfd.repos;

import org.example.bookfd.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
   User findById(int id);
   List<User> findByIdIn(List<Integer> listUsersId);

}
