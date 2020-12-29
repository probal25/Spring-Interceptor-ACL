package com.probal.userapp.repository;

import com.probal.userapp.model.Role;
import com.probal.userapp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u from User u Where u.username = :username")
    public User getUserByUsername(@Param("username") String username);
}
