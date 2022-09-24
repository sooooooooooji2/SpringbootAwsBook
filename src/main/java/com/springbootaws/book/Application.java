package com.springbootaws.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing      // BaseTimeEntity 사용할려고 추가함 , jpa auditing 활성함
@SpringBootApplication  //스프링부트의 자동설정, 스프링 bean 읽기와 생성 모두 자동으로 설정됨, 항상 프로젝트 최상단에 위치해야됨
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
