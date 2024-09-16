package com.example.implwebsitev2.repository;

import com.example.implwebsitev2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// JpaRepositoy는 Spring Data JPA에서 제공하는 기본적인 CRUD 기능 포함하고 있음
// <User, Long> ==> 를 통해 선언된 User 엔티티와 매핑된다. 고유키 타입 == Long
public interface UserRepository extends JpaRepository<User, String> {

}
