package com.springbootaws.book.domain.posts;

import com.springbootaws.book.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter             //롬복 어노테이션 : 클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor  //롬복 어노테이션 : 기본 생성자 자동추가, public Posts{} 같은 효과
@Entity     // jpa 어노테이션 , 테이블과 링크될 클래스임
public class Posts extends BaseTimeEntity {

    @Id        // 해당 테이블의 pk필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 생성규칙을 나타냄
    private Long id;    // pk는 long 타입으로 추천

    @Column(length = 500, nullable = false) // @coulumn 테이블의 컬럼을 나타냄. 굳이 선언해도 x, 필요한 옵션이 있을 때 사용함
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // 해당 클래스의 빌더 패턴 클래스 생성 , 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}