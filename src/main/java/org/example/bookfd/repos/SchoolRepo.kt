package org.example.bookfd.repos;

import org.example.bookfd.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School,Long> {
    School findById(int id);
}
