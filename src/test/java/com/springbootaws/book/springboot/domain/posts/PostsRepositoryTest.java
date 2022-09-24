package com.springbootaws.book.springboot.domain.posts;

import com.springbootaws.book.domain.posts.Posts;
import com.springbootaws.book.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired                          // 안쓰면 에러
    PostsRepository postsRepository;

    @After                              // Junit 에서 단위테스트가 끝날 때 마다 수행됨 , 전체 테스트 수행할 때 테스트 간 데이터 침법을 막기 위해 씀
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(           // insert & update 쿼리 실행 , id 값이 있다면 update 없으면 insert
                Posts.builder()
                .title(title)
                .content(content)
                .author("~~~@email.com").build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();  // findAll() : 모든 데이터를 조회함

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2022,9,22,0,0,0);

        postsRepository.save(Posts.builder()
                .title("title_base")
                .content("content_base")
                .author("수지짱")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>createDate" + posts.getCreatedDate()
                +" , modifiedDate = " + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
