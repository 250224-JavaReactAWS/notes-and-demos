package com.revature.repos;

import com.revature.models.Course;
import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    Optional<User> findUserByEmail(String email);

    // JPQL
    @Query("SELECT u.courses FROM User u WHERE u.userId = :userId")
    List<Course> getCoursesByUserId(@Param("userId") int userId);
}
