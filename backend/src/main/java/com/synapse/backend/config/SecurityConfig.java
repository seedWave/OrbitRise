package com.synapse.backend.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Spring Security Filter Chain 정의
     * - JWT 인증 기반이므로 Stateless 세션 유지
     * - /auth, /user, /api 등은 인증 없이 접근 가능
     */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // HTTP Basic 인증 비활성화 및 401 에러 리턴 설정 (HTTPS 설정)
                .httpBasic(httpBasic -> httpBasic.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                // CSRF 보호 비활성화 (JWT 방식이므로 서버에 세션 상태를 저장하지 않기 때문)
                .csrf((AbstractHttpConfigurer::disable))
                // CORS 설정
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(//HTTP 요청에 대해 어떤 "인가(authorization)" 정책을 적용할지 설정
                        authorizeRequests ->
                                authorizeRequests
                        .requestMatchers("/synapse/login", "/error").permitAll()
                        .anyRequest().authenticated()//위에 지정한 것들을 제외한 나머지 모든 요청은 로그인한 사용자만 접근 가능
                )
                .formLogin(form -> form
                        .loginPage("/synapse/login") // 커스텀 로그인 경로
                        .defaultSuccessUrl("/synapse/user/dashboard", true) // 로그인 성공 후 무조건 이동
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/synapse/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    /**
     * CORS 설정 정의
     * - 프론트엔드와 도메인이 다른 경우에도 요청 허용
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:12345"    // 로컬 환경
//                ,"https://knock-six.vercel.app"                            // 프론트 vercel 배포 환경
//                ,"https://knock-f24a348e0f1e.herokuapp.com/"                 // 백엔드 heroku 배포 환경
        ));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));       // 허용할 HTTP 메서드
        configuration.setAllowedHeaders(List.of("Content-Type", "Authorization"));      // 허용할 요청 헤더
        configuration.setExposedHeaders(List.of("Authorization", "Set-Cookie"));        // 클라이언트에서 접근 가능한 응답 헤더
        configuration.setAllowCredentials(true); // 쿠키와 인증정보 포함 허용

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
