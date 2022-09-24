package com.springbootaws.book.service.posts;

import com.springbootaws.book.domain.posts.Posts;
import com.springbootaws.book.domain.posts.PostsRepository;
import com.springbootaws.book.web.dto.PostsResponseDto;
import com.springbootaws.book.web.dto.PostsSaveRequestDto;
import com.springbootaws.book.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor        //생성자를 통한 bean 주입방식
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id =  "  + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(long id){
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다 . id = " + id));

        return new PostsResponseDto(entity);
    }
}
