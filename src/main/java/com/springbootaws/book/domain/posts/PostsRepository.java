package com.springbootaws.book.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Repository : Dao 역할을 하는 DB Layer 접근자
//인터페이스로 생성해야함
//JpaRepository<Entity클래스명 , pk타입> 으로 상속해야함
//Entity 클래스와 Repository 는 함께 위치해야함 (중요*****)

//findAll() : 모든데이터 조회
//deleteAll : 모든데이터 삭제
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
