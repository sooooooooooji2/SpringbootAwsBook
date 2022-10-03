package com.springbootaws.book.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Optional : Java8부터 Optional<T>클래스를 사용해 NullPointerException(이하 NPE)를 방지할수 있도록 했다.
//           Optional<T> 클래스는 Integer나 Double클래스처럼 T타입의 객체를 포장해주는 래퍼클래스이다.
//           Optional<T>는 null이 올수 있는 값을 감싸는 Wrapper클래스로, 참조하더라도 NPE가 발생하지 않도록 도와준다.
//           즉, 예상치못한 NPE예외를 제공되는 메소드로 간단히 회피할 수 있어 복잡한 조건문 없이도 null값으로 인해 발생하는 예외를 처리할 수 있다.
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email); //소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성된 사용자 & 가입한 사람인지 판단하기 위한 메소드
}
