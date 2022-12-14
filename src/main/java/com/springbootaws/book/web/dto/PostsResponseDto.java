package com.springbootaws.book.web.dto;

import com.springbootaws.book.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) { //Entity 필드 중 일부만 사용하므로 생성자로 entity 를 받아 필드에 값을 넣음
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
