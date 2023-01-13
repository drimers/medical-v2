//package com.stefanpetkov.medical.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
////@Configuration
////@EnableWebSecurity
//public class SecurityConfiguration {
//
//
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
//
//
////        @Override
////        protected void configure(HttpSecurity httpSecurity) throws Exception {
////            httpSecurity.authorizeRequests().antMatchers("/home/**").permitAll().and()
////                    .formLogin() .loginPage("/login").permitAll().and()
////                    .authorizeRequests().antMatchers("/h2-console/**").permitAll();
////            httpSecurity.csrf().disable();
////            httpSecurity.headers().frameOptions().disable();
////        }
//
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .csrf().disable()
////                .authorizeRequests().antMatchers("/home", "/register", "/save", "/logon","/h2-console/**", "/webapp/**", "/vendor/**", "/src/main/webapp/assets/**", "/fonts/**", "/css/**", "/js/**", "/img/**", "/patient/patient/").permitAll()
////                .and()
////                .authorizeRequests().antMatchers()
////                .permitAll().anyRequest().authenticated()
////                .and()
////                .formLogin().loginPage("/login")
////                .permitAll()
////                .and()
////
////                .logout().invalidateHttpSession(true)
////                .clearAuthentication(true).permitAll();
////
////        http.headers().disable();
////    }
//
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .csrf().disable()
////                .authorizeRequests().antMatchers("/h2-console/**", "/webapp/**", "/vendor/**", "/src/main/webapp/assets/**", "/fonts/**", "/css/**", "/js/**", "/img/**", "/patient/patient/").permitAll()
////                .and()
////                .authorizeRequests().antMatchers("/home", "/register", "/save", "/logon")
////                .permitAll().anyRequest().authenticated()
////                .and()
////                .formLogin().loginPage("/login")
////                .permitAll()
////                .and();
////
////                .logout().invalidateHttpSession(true)
////                .clearAuthentication(true).permitAll();
////
////        http.headers().disable();
////    }
////        http
////                .headers().frameOptions().sameOrigin()
////                .httpStrictTransportSecurity().disable();
////    }
//
//
////    @Override
////    protected void configure(final HttpSecurity http) throws Exception {
////
////
////
////        //@formatter:off
////        http.authorizeRequests()
////                .antMatchers("/login").permitAll()
////                .antMatchers("/**").hasAnyRole( "PATIENT","ADMIN")
////                .antMatchers("/admin/**").hasAnyRole("ADMIN")
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .loginProcessingUrl("/logon")
////                .defaultSuccessUrl("/home")
////                .failureUrl("/login?error=true")
////                .permitAll()
////                .and()
////                .logout()
////                .logoutSuccessUrl("/login?logout=true")
////                .invalidateHttpSession(true)
////                .deleteCookies("JSESSIONID")
////                .permitAll()
////                .and()
////                .csrf()
////                .disable();
////        //@formatter:on
////    }
//
////    @Override
////    public void configure(WebSecurity web) {
////        web.ignoring()
////                .antMatchers("/home/**", "/h2-console/**");
////    }
//
//
//}
//
