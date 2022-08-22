package com.scm.login.repository;

import com.scm.login.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findUserByLoginIdAndLoginPw(String userId, String password);

    @Query("SELECT tb.userNm FROM UserEntity tb WHERE tb.userId = :userId")
    Optional<String> findUserNameByUserId(@Param("userId") String userId);
}
