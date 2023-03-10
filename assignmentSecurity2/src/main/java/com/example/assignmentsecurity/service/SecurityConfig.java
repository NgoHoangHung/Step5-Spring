package com.example.assignmentsecurity.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    * UserDetailsService là một interface trong Spring Security được sử dụng để
    * lấy thông tin của người dùng từ một nguồn bên ngoài như cơ sở dữ liệu hoặc LDAP.
    * Nó cung cấp một phương thức loadUserByUsername(username) để tìm kiếm thông tin
    * người dùng dựa trên tên người dùng (username) và trả về một đối tượng UserDetails.

    Luồng làm việc của UserDetailsService trong Spring Security như sau:

    1. Khi người dùng cố gắng đăng nhập vào hệ thống, Spring Security sẽ tìm kiếm thông tin
    người dùng trong UserDetailsService.

    2. Nếu UserDetailsService trả về một đối tượng UserDetails, Spring Security sẽ
    sử dụng nó để xác thực người dùng.

    3. Nếu không tìm thấy người dùng hoặc có lỗi xảy ra, Spring Security sẽ
    ném ra một ngoại lệ.

    Vì vậy, UserDetailsService là một phần quan trọng trong việc xác thực người dùng
    trong Spring Security và cho phép các ứng dụng xác thực người dùng
    từ các nguồn dữ liệu khác nhau.*/

    @Bean
    public UserDetailsService inMemoryDetailService() {
        User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder()::encode);
        UserDetails user1 = userBuilder.username("hung1").password("123").roles("Admin").build();
        UserDetails user2 = userBuilder.username("hung2").password("123").roles("Operator").build();
        UserDetails user3 = userBuilder.username("hung3").password("123").roles("User").build();
        /*
         * ta tiến hành tạo mới một danh sách các UserDetails gồm các thông tin ta vừa tạo
         * */
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }    /*
     * InMemoryUserDetailsManager là một implementation của UserDetailsService interface,
     *  nó được sử dụng để lưu trữ và xác thực thông tin người dùng trong bộ nhớ.
     * Khi ta tạo một đối tượng InMemoryUserDetailsManager,
     * ta truyền vào danh sách các đối tượng
     * UserDetails (chứa thông tin về username, password, roles, ...)
     * thông qua hàm tạo. Sau đó, InMemoryUserDetailsManager sẽ lưu trữ danh sách người dùng
     *  này và sử dụng nó để xác thực các yêu cầu đăng nhập được gửi đến nó.*/

    /*
    chúng ta sẽ mã hóa mật khẩu dựa vào việc khai báo các
    cách thức mã hóa trong delegatingPasswordEncoder()
     các cách thức mã hóa được quản lí bằng hashmap

     * */
    private PasswordEncoder delegatingPasswordEncoder(String encodeType) {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        return new DelegatingPasswordEncoder(encodeType, encoders);
    }

    /*
     * tạo ra bean để truyền vào các phương thức passwordEncoder
     * khai báo phương thức mã hóa
     * */
    @Bean
    public PasswordEncoder encoder() {
        return delegatingPasswordEncoder("bcrypt");
    }

    /*
     * khi ta cấu hình lại lớp WebSecurityConfigurerAdapter, ta sẽ ghi đè lại phương thức configure
     *  để cấu hình quyền hạn,trang đăng nhập
     * Việc cấu hình lại ta có thể coi là một khối các đoạn lệnh
     * phân cách nhau bằng phương thức and()
     * */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(inMemoryDetailService());
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .accessDeniedPage("/un-authorizes")
                .and()
                .authorizeRequests()
                .antMatchers("/**/user").hasAnyRole("Admin", "User", "Operator")
                .antMatchers("/**/operator").hasAnyRole("Admin", "Operator")
                .antMatchers("/**/admin").hasRole("Admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
                .loginPage("/api/logincustom")
                .loginProcessingUrl("/api/login")
                .permitAll();
    }
}
