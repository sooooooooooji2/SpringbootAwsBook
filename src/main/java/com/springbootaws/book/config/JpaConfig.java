package com.springbootaws.book.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing  // JPA Auditing 활성화, Application.java 에서 분리 후 JpaConfig 클래스 생성한 후 활성화 시킴
public class JpaConfig {
}
