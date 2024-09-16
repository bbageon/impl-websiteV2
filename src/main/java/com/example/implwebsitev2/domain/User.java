package com.example.implwebsitev2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Entity
//@Table(name ="user")  // 사용하지 않으면 클래스 이름이 테이블 이름이 됨
@Getter
@Setter
public class User {
    @Id // 기본키를 의미
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user_id;

    @NonNull
    @Column()
    private String user_email;

    @NonNull
    @Column(length = 15)
    private String user_password;

    @NonNull
    @Column()
    private String user_name;

}
