package com.springbootaws.book.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)      //어노테이션이 생성될 수 있는 위치를 지정. parameter로 지정했으니 메소드의 파라미터로 선언된 객체에서만 사용가능
@Retention(RetentionPolicy.RUNTIME) //어느 시점까지 어노테이션의 메모리를 가져갈 지 설정
public @interface LoginUser {   // 이 파일을 어노테이션 클래스로 지정함
}
