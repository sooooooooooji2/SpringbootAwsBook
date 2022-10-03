package com.springbootaws.book.config.auth;

import com.springbootaws.book.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //spring security 설정들을 활성화시켜줌
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console 화면을 사용하기 위해 해당옵션들을 disable 처리함
                .and()
                .authorizeRequests()    //url별 권한 관리 설정하는 옵션의 시작점, 이걸 선언해야 antMatchers 사용가능
                //antMatchers 권한 관리 대상을 지정하는 옵션. url,http 메소드별로 관리 가능. "/" 등 지정된 url들은 permitAll() 옵션을 통해 전체 열람권한을 줌
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())       //"/api/v1/**" 주소를 가진 api는 user 권한을 가진 사람만 가능
                .anyRequest().authenticated()   //설정된 값들 이외 나머지 url들을 나타냄. 인증된 사용자(로그인한 사용자)들만 허용하게함
                .and()
                .logout()   //로그아웃기능에 대한 여러 설정 진입점
                .logoutSuccessUrl("/")      //로그아웃 성공시 "/" 주소로 이동
                .and()
                .oauth2Login()  //oAuth2 로그인 기능에 대한 여러 설정의 진입점
                .userInfoEndpoint() //oAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당
                .userService(customOAuth2UserService);  //소셜 로그인 성공 시 후속 조치를 진행 할 인터페이스의 구현체를 등록함
    }
}
