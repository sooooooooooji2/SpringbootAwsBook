package com.springbootaws.book.web;

import org.apache.catalina.security.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)    //스프링부트 테스트와 junit 사이에 연결자 역할을함 , springrunner라는 스프링 실행자 사용
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }   //스프링 테스트 어노테이션 중 web에 집중할 수 있는 어노테이션, service & component & repository 는 사용 x,  controller & controllerAdvice는 사용 o
)
public class HelloControllerTest {

    @Autowired  //스프링이 관리하는 빈을 주입 받음
    private MockMvc mvc;    //웹 api 테스트 할 때 사용, 스프링 mvc 테스트의 시작점, http &get & post 등 api 테스트 할 수 o

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "helloaws";

        mvc.perform(get("/hello"))  // mockmvc 를 통해 hello 주소로 http get 요청
                .andExpect(status().isOk())     // .perform 결과 검증, http header의 status 검증
                .andExpect(content().string(hello));    // .perform 결과 검증, 응답 내용이 hello 인지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
