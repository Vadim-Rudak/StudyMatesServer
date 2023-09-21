package org.example.bookfd.repos;

import org.example.bookfd.domain.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo,Long> {
    Photo findById(int id);
}
