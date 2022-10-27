//Неудачная попытка spring-security, не понял как аутентифицироваться в постмане


//package org.rodko.userdatabase.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.annotation.PostConstruct;
//import javax.sql.DataSource;
//
//@EnableWebSecurity
//@Configuration
//public class UsrSecurityConfig  {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .antMatchers("/api/**").authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .logout().logoutSuccessUrl("/")
//                .and()
//                .httpBasic();
//        return http.build();
//    }
//
//    @Bean
//    public JdbcUserDetailsManager users(DataSource dataSource){
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{bcrypt}$2a$12$KmEUshkWHCPSG/kplWGlq.4smXa1Mo1I7kq1i9Yle.CI0kFWKx0k6")
//                .roles("ADMIN")
//                .build();
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        if (jdbcUserDetailsManager.userExists(admin.getUsername())){
//            jdbcUserDetailsManager.deleteUser(admin.getUsername());
//        }
//        jdbcUserDetailsManager.createUser(admin);
//        return jdbcUserDetailsManager;
//    }
//
//
////    @Bean
////    public UserDetailsService users() {
////        UserDetails admin = User.builder()
////                .username("admin")
////                .password("admin")
////                .build();
////        return  new InMemoryUserDetailsManager(admin);
////    }
//}
