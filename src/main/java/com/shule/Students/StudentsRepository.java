package com.shule.Students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentsRepository extends JpaRepository<Students, Long> {


    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "SELECT * FROM learners WHERE registration_number = :registrationNumber")
    Optional<Students> searchByregNumber(@Param("registrationNumber") String registrationNumber);


    Students findByregistrationNumber(String registrationNumber);

}
