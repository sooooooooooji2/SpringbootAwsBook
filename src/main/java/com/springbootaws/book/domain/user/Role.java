package com.springbootaws.book.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//각 사용자의 권한을 관리할 클래스
@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "손님"),      //스프링 시큐리티에서는 권한 코드에 항상 "ROLE_"이 앞에 붙어야함
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
