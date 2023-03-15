package com.example.demo1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

/*
 * đây là class cấu hình cho phương thức AuthenProvider theo cách ta tùy chình
 * và nó được triển khai từ AuthenticationProvider nhằm xây dựng lại
 * các phương thức theo cách của chúng ta
 * */
@Component
public class CustomAuthenProvider implements AuthenticationProvider {
    //sử dụng bean InMemoryUserDetailsManager cho việc tìm tài khoản lưu trữ trong kho
    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
    //sử dụng bean PasswordEncoder cho việc mã hóa pass nhập vào từ bàn phím để
    //so sánh với pass trong kho dữ liệu đã được mã hóa trước đó
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        /*
         * chứa thông tin về quá trình xác thực của người dùng, bao gồm thông tin về tên đăng nhập,
         *  mật khẩu, quyền truy cập và các thông tin xác thực khác
         * đây là công cụ của spring
         *
         * */
        String username = authentication.getName();
        String rawPassword = String.valueOf(authentication.getCredentials());
        //sau khi lấy xong được user name password thì ta tiến hành tìm và đối chiếu
        try {
            UserDetails userDetails = inMemoryUserDetailsManager.loadUserByUsername(username);
            /* phương thức loadUserByUsername tạo ra một đối tượng UserDetails chứ chưa làm gì cả.
             nó bao gồm các thông tin
            * User(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),
				user.isCredentialsNonExpired(), user.isAccountNonLocked(), user.getAuthorities());
            * */
            if (encoder.matches(rawPassword, userDetails.getPassword()))//tiến hành so sánh đối chiếu
                //nếu đúng thì trả về một authentication. nó được sử dụng trong suốt một phiên làm việc
                /*UsernamePasswordAuthenticationToken(Object principal, Object credentials,
                        Collection<? extends GrantedAuthority > authorities)
                        sau khi authenticantion được tạo ra thì ta sẽ không truyền trực tiếp nó vào trong
                         configure(AuthenticationManagerBuilder auth)
                        mà ta sẽ truyền qua AuthenticvationProvider.
                         chúng ta sẽ sử dụng AuthenticationManager để xác thực các yêu cầu từ người dùng.
                         AuthenticationManager được tạo ra bởi AuthenticationManagerBuilder và sẽ được
                         sử dụng để xác thực các đối tượng Authentication
                         được truyền vào từ các yêu cầu từ người dùng.
                        */
                return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
            else
                return null;
        } catch (UsernameNotFoundException e) {
            return null;
        }
    }

    /*phương thức suport sẽ kiểm tra loại authentication này có được hỗ trợ bởi
     * authenticationprovider hay không
     * một số loại authentication ko được hỗ trợ như
     * RememberMeAuthenticationToken PreAuthenticatedAuthenticationToken AnonymousAuthenticationToken
     * */
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
