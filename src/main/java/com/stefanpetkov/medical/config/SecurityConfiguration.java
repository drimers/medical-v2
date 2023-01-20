package com.stefanpetkov.medical.config;


//TODO: form login 
//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/h2-console/**", "/webapp/**", "/vendor/**", "/src/main/webapp/assets/**", "/fonts/**", "/css/**", "/js/**", "/img/**", "/patient/patient/")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin().loginPage("/login")
//                .permitAll()
//                .and()
//                .logout().invalidateHttpSession(true)
//                .clearAuthentication(true).permitAll();
//        return http.build();
//    }

}
