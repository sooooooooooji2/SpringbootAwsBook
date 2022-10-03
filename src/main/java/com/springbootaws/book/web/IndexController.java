package com.springbootaws.book.web;

import com.springbootaws.book.config.auth.LoginUser;
import com.springbootaws.book.config.auth.dto.SessionUser;
import com.springbootaws.book.service.posts.PostsService;
import com.springbootaws.book.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    // #### 4장 추가
    private final PostsService postsService;
    // #### 5장 추가
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {      // model : 서버 템플릿 엔진에서 사용할수 있는 객체 //5장에 어노테이션 @LoginUser 추가함
        model.addAttribute("posts", postsService.findAllDesc());

        // #### 5장 추가
        // 어노테이션 추가함으로 밑에코드는 주석처리함 (반복되는 부분을 없애기 위해서 어노테이션 추가함)
        // SessionUser user = (SessionUser) httpSession.getAttribute("user"); // customoauth2userservice에서 로그인 성공시 세션에 sessionUser 저장하도록 구성함
        if(user != null) {    // 세션에 저장된 값이 있을 대만 model에 userName을 등록함
            model.addAttribute("userName",user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
