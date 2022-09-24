package com.springbootaws.book.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Repository : Dao 역할을 하는 DB Layer 접근자
//인터페이스로 생성해야함
//JpaRepository<Entity클래스명 , pk타입> 으로 상속해야함
//Entity 클래스와 Repository 는 함께 위치해야함 (중요*****)

//findAll() : 모든데이터 조회
//deleteAll : 모든데이터 삭제
public interface PostsRepository extends JpaRepository<Posts, Long> {

    //#### 4장에서 추가함 START
    @Query("select p from Posts p order by p.id desc")      // springdatajpa 에서 제공하지 않는 메소드이나 가독성이 좋아서 쓰임
    List<Posts> findAllDesc();
    //#### 4장에서 추가함 END
}
