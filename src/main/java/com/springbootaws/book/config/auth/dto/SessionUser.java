package com.springbootaws.book.config.auth.dto;

import com.springbootaws.book.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {  //직렬화 (object ,data -> byte) 형태로 데이터를 변환하는 기술
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
