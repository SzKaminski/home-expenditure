package com.szkaminski.demo.backend.repositories;

import com.szkaminski.demo.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User where name like %:name%")
    User findByName(@Param("name")String name);

}
