    ==> Luồng làm việc trong spring security
    
    Luồng hoạt động của Spring Security trong một ứng dụng web có thể được mô tả như sau:
    
    a, Khi một request được gửi đến server, nó được đưa vào một chuỗi các filter - Security Filter Chain. 
    Chuỗi này bao gồm nhiều bộ lọc (filter) khác nhau, từ Authentication Filter đến Authorization Filter và 
    cuối cùng là Exception Handling Filter.
    
    b, Authentication Filter sẽ kiểm tra xem request có chứa thông tin đăng nhập hay không. Nếu có, 
    Authentication Filter sẽ gửi thông tin đăng nhập tới Authentication Manager để xác thực. 
    Nếu không, Authentication Filter sẽ tiếp tục cho request đi qua các bộ lọc khác trong chuỗi.
    
    c, Authentication Manager sẽ thực hiện việc xác thực thông tin đăng nhập, thông qua các Authentication Provider.
    Mỗi Authentication Provider sẽ kiểm tra thông tin đăng nhập và trả về một Authentication object nếu thông tin 
    đúng.
    
    d, Nếu xác thực thành công, Authentication Filter sẽ tạo một Authentication object và đưa nó vào 
    Security Context Holder. Nếu không, một Exception sẽ được gửi đến Exception Handling Filter để xử lý.
    
    e, Authorization Filter sẽ tiếp nhận request từ Authentication Filter và kiểm tra quyền truy cập của người dùng.
    Nếu người dùng được phép truy cập, request sẽ tiếp tục đi qua các bộ lọc khác trong chuỗi.
    
    f, Nếu request không được phép truy cập, Authorization Filter sẽ trả về HTTP 403 Forbidden.
    
    g, Exception Handling Filter sẽ được sử dụng để xử lý các lỗi xảy ra trong quá trình xác thực và phân quyền, 
    như AuthenticationException hoặc AccessDeniedException.
    
    h, Sau khi request đi qua Security Filter Chains và các bộ lọc khác, nó sẽ được gửi đến Controller để xử lý. 
    Nếu Controller trả về response, response đó sẽ đi qua cùng một chuỗi các bộ lọc và được gửi trở lại client.

i,UserNamePassword Authentication Tolen trong security là gì
    
    Trong Spring Security, UsernamePasswordAuthenticationToken là một đối tượng đại diện cho thông tin xác thực
    của người dùng (authentication) được cung cấp dưới dạng tên người dùng và mật khẩu (username/password).
    Đối tượng này được tạo ra bởi các bộ lọc xác thực và được sử dụng bởi Spring Security để thực hiện việc 
    xác thực người dùng.

    Khi người dùng đăng nhập, thông tin đăng nhập sẽ được gửi đến server và đối tượng 
    UsernamePasswordAuthenticationToken sẽ được tạo ra. Đối tượng này sẽ được gửi đến AuthenticationManager
    để xác thực và trả về một đối tượng Authentication chứa các thông tin về người dùng đã được xác thực.
    Nếu xác thực thành công, đối tượng UsernamePasswordAuthenticationToken sẽ được lưu trữ trong phiên làm việc 
    của người dùng và được sử dụng cho các yêu cầu tiếp theo của người dùng.

    Để giải thích ví dụ về UsernamePasswordAuthenticationToken, ta có thể tưởng tượng một trang web yêu cầu người dùng đăng nhập để truy cập nội dung được bảo vệ.

    Khi người dùng nhập tên người dùng và mật khẩu, hệ thống sẽ tạo ra một đối tượng 
    UsernamePasswordAuthenticationToken từ thông tin đăng nhập này. 
    Ví dụ:
    String username = "exampleUser";
    String password = "examplePassword";
    Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
    Đối tượng authentication ở đây sẽ được sử dụng để xác thực người dùng trên hệ thống. Nếu thông tin đăng nhập 
    đúng, đối tượng này sẽ được gán cho một đối tượng SecurityContext, và từ đó, người dùng sẽ được xác thực 
    để truy cập nội dung được bảo vệ trên trang web.

ii,AuthenticationMánager là gì.

    AuthenticationManager là một giao diện quan trọng trong Spring Security, nó được sử dụng để xác thực người dùng
    Nó có nhiệm vụ xác thực thông tin đăng nhập của người dùng (username, password) và cung cấp một đối tượng 
    Authentication chứa thông tin xác thực của người dùng.
    
    Đối tượng AuthenticationManager sẽ được sử dụng bởi Spring Security để xác thực người dùng trong quá trình 
    đăng nhập. Nó có thể sử dụng các đối tượng UserDetailsService để lấy thông tin người dùng và các 
    PasswordEncoder để mã hóa và so sánh mật khẩu người dùng với mật khẩu đã lưu trữ.
    
    Ví dụ:
    
    Ta có một ứng dụng web Spring Security đơn giản, trong đó người dùng có thể đăng nhập để xem các trang bảo mật
    ta đã cấu hình AuthenticationManager để sử dụng InMemoryUserDetailsManager và PasswordEncoder để xác thực 
    người dùng. ta đã cấu hình trang đăng nhập để gửi yêu cầu POST đến URL "/login" với các tham số "username" 
    và "password".
    
    ta có thể tạo một đối tượng AuthenticationManager trong lớp cấu hình Spring Security của mình như sau:
    
    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll()
                .antMatchers("/secure/**").hasRole("USER")
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/secure/home")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        Collection<UserDetails> users = new ArrayList<>();
        User.UserBuilder userBuilder = User.builder().passwordEncoder(passwordEncoder::encode);
        var hung1 = userBuilder.username("hung1").password("123").roles("USER").build();
        var hung2 = userBuilder.username("hung2").password("123").roles("USER").build();
        var hung3 = userBuilder.username("hung3").password("123").roles("USER").build();
        users.add(hung1);
        users.add(hung2);
        users.add(hung3);
        return new InMemoryUserDetailsManager(users);
    }

}

    Trong đoạn mã trên, toi  đã cấu hình AuthenticationManagerBuilder để sử dụng UserDetailsService 
    được cung cấp bởi InMemoryUserDetailsManager và PasswordEncoder được cung cấp bởi BCryptPasswordEncoder. 
    Bạn cũng đã cấu hình HttpSecurity để xác thực người dùng với vai trò "USER" để truy cập vào các trang tài nguyên

iii, AuthenticationProvider là gì.
    
    AuthenticationProvider là một interface trong Spring Security, định nghĩa các phương thức cần được triển khai
    để xác thực (authenticate) một đối tượng Authentication.
    
    Các lớp triển khai của AuthenticationProvider sẽ đọc thông tin xác thực từ nhiều nguồn, như cơ sở dữ liệu, 
    ệp văn bản hoặc LDAP, và kiểm tra thông tin đăng nhập có hợp lệ không. Nếu thông tin đăng nhập không chính xác,
    nó sẽ tạo ra một ngoại lệ AuthenticationException để báo lỗi.
    
    Ví dụ, giả sử bạn đang phát triển một ứng dụng web Spring Security và muốn sử dụng cơ chế xác thực 
    dựa trên tệp văn bản để xác thực người dùng. Bạn có thể triển khai một lớp MyAuthenticationProvider,
    kế thừa từ AuthenticationProvider và triển khai phương thức authenticate như sau:
    @Component
    public class MyAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();
    
            // kiểm tra thông tin đăng nhập có hợp lệ không
            if ("user".equals(username) && "password".equals(password)) {
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            } else {
                throw new BadCredentialsException("Invalid username or password");
            }
        }
    
        @Override
        public boolean supports(Class<?> authentication) {
            return authentication.equals(UsernamePasswordAuthenticationToken.class);
        }
    }
    
    Trong ví dụ này, phương thức authenticate() sẽ lấy thông tin đăng nhập từ đối tượng Authentication 
    được truyền vào và kiểm tra nó bằng cách so sánh với thông tin trong tệp văn bản. Nếu thông tin đăng nhập 
    chính xác, nó sẽ trả về một đối tượng UsernamePasswordAuthenticationToken. Ngược lại, nó sẽ ném một ngoại lệ
    BadCredentialsException.
    
    Phương thức supports() xác định lớp đối tượng Authentication nào được hỗ trợ bởi AuthenticationProvider này.
    Trong trường hợp này, chỉ đối tượng UsernamePasswordAuthenticationToken được hỗ trợ.
    
    
    iv,PasswordEncoder có chức năng gì
    PasswordEncoder là một interface trong Spring Security được sử dụng để mã hóa mật khẩu của người dùng trước khi lưu trữ vào cơ sở dữ liệu hoặc so sánh với mật khẩu đã lưu trữ trong cơ sở dữ liệu.
    
    Ví dụ: Khi một người dùng đăng ký tài khoản trên một trang web, mật khẩu của họ sẽ được mã hóa và lưu trữ trong cơ sở dữ liệu để đảm bảo an toàn. Khi người dùng đăng nhập vào trang web bằng tài khoản của họ, mật khẩu sẽ được so sánh với mật khẩu đã lưu trữ trong cơ sở dữ liệu. Nếu chúng giống nhau, người dùng sẽ được phép truy cập vào trang web.
    
    Dưới đây là một ví dụ về cách sử dụng PasswordEncoder trong Spring Security:
    PasswordEncoder là một interface trong Spring Security được sử dụng để mã hóa mật khẩu của người dùng trước khi lưu trữ vào cơ sở dữ liệu hoặc so sánh với mật khẩu đã lưu trữ trong cơ sở dữ liệu.
    
    Ví dụ: Khi một người dùng đăng ký tài khoản trên một trang web, mật khẩu của họ sẽ được mã hóa và lưu trữ trong cơ sở dữ liệu để đảm bảo an toàn. Khi người dùng đăng nhập vào trang web bằng tài khoản của họ, mật khẩu sẽ được so sánh với mật khẩu đã lưu trữ trong cơ sở dữ liệu. Nếu chúng giống nhau, người dùng sẽ được phép truy cập vào trang web.
    
    Dưới đây là một ví dụ về cách sử dụng PasswordEncoder trong Spring Security:
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public void registerUser(User user) {
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    userRepository.save(user);
    }
    Trong ví dụ này, một đối tượng PasswordEncoder được khởi tạo bằng cách sử dụng lớp BCryptPasswordEncoder. 
    Sau đó, đối tượng PasswordEncoder được sử dụng để mã hóa mật khẩu của người dùng trước khi lưu trữ vào 
    cơ sở dữ liệu. Phương thức encode() của đối tượng PasswordEncoder được sử dụng để mã hóa mật khẩu.

v,UserDetailService ,UserDetaill, User trong security là gì.

    Trong Spring Security, UserDetailsService là một interface được sử dụng để tìm kiếm thông tin người dùng. 
    Nó được sử dụng trong quá trình xác thực người dùng để lấy thông tin về người dùng dựa trên tên người dùng.
    
    Một đối tượng UserDetails chứa các thông tin cơ bản về một người dùng như tên người dùng, mật khẩu và 
    các quyền hạn. Nó được sử dụng bởi UserDetailsService để trả về thông tin người dùng tìm thấy.
    
    Ví dụ, giả sử chúng ta có một bảng trong cơ sở dữ liệu của chúng ta lưu trữ thông tin về người dùng, 
    bao gồm tên đăng nhập, mật khẩu đã được mã hóa và các quyền hạn. Chúng ta có thể triển khai 
    UserDetailsService để lấy thông tin về người dùng từ bảng này và trả về một đối tượng UserDetails.
    Sau đó, chúng ta có thể sử dụng các thông tin này để xác thực người dùng trong quá trình đăng nhập.
    
    Ví dụ code để triển khai UserDetailsService và UserDetails trong Spring Security:
    
    @Service
    public class UserDetailsServiceImpl implements UserDetailsService {
    
        @Autowired
        private UserRepository userRepository;
    
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userRepository.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (Role role : user.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), authorities);
        }
    }
    
    @Entity
    public class User {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column(unique = true)
        private String username;
    
        private String password;
    
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "user_role",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id")
        )
        private Set<Role> roles = new HashSet<>();
    
        // getters and setters
    }
    
    public class CustomUserDetails implements UserDetails {
    
        private String username;
        private String password;
        private Collection<? extends GrantedAuthority> authorities;
    
        public CustomUserDetails(String username, String password,
                                 Collection<? extends GrantedAuthority> authorities) {
            this.username = username;
            this.password = password;
            this.authorities = authorities;
        }
    
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }
    
        @Override
        public String getPassword() {
            return password;
        }
    
        @Override
        public String getUsername() {
            return username;
        }
    
        // ... other methods
    }
    
    Ở đây, UserDetailsServiceImpl là một implement của interface UserDetailsService.
    Trong phương thức loadUserByUsername(), chúng ta lấy thông tin người dùng từ cơ sở dữ liệu và trả về 
    một đối tượng `UserDetailschứa thông tin đó.UserDetails` là một interface của Spring Security định nghĩa 
    các thuộc tính cần thiết để xác thực và phân quyền người dùng.
    
    Ví dụ, nếu bạn có một ứng dụng web yêu cầu người dùng đăng nhập, bạn cần cung cấp thông tin đăng nhập
    của người dùng, bao gồm tên đăng nhập và mật khẩu. Để xác thực người dùng, bạn có thể sử dụng một 
    UserDetailService để tìm kiếm thông tin người dùng trong cơ sở dữ liệu và trả về một đối tượng UserDetails.
    
    Ví dụ, nếu bạn có một bảng người dùng trong cơ sở dữ liệu MySQL, với các cột tương ứng là username, password, 
    và enabled để xác định tên đăng nhập, mật khẩu và trạng thái kích hoạt của người dùng, thì bạn có thể tạo 
    một lớp UserDetailsServiceImpl để kết nối tới cơ sở dữ liệu và lấy thông tin người dùng, 
    và trả về một đối tượng UserDetails chứa thông tin đăng nhập và quyền hạn của người dùng.
    
    @Service
    public class UserDetailsServiceImpl implements UserDetailsService {
    
        @Autowired
        private UserRepository userRepository;
     
        @Override
        public UserDetails loadUserByUsername(String username)
                throws UsernameNotFoundException {
            User user = userRepository.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    user.isEnabled(), true, true, true, getAuthorities(user.getRoles()));
        }
     
        private Collection<? extends GrantedAuthority> getAuthorities(
                Collection<Role> roles) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            return authorities;
        }
    }
    Ở ví dụ này, chúng ta tạo một lớp UserDetailsServiceImpl để tìm kiếm thông tin người dùng trong cơ sở dữ liệu
    thông qua repository UserRepository. Phương thức loadUserByUsername sử dụng repository để tìm kiếm người dùng 
    theo tên đăng nhập. Nếu người dùng không tồn tại, phương thức sẽ ném ra một UsernameNotFoundException. 
    Nếu người dùng tồn tại, phương thức sẽ trả về một đối tượng UserDetails chứa thông tin đăng nhập và quyền hạn 
    của người dùng, bao gồm cả tên đăng nhập, mật khẩu đã được mã hóa, trạng thái kích hoạt và các quyền hạn.
    Sau khi tìm thấy thông tin người dùng từ cơ sở dữ liệu, phương thức loadUserByUsername sẽ trả về một đối tượng 
    UserDetails chứa các thông tin đăng nhập và quyền hạn của người dùng. Đối tượng UserDetails được sử dụng 
    bởi Spring Security để thực hiện xác thực và ủy quyền trong ứng dụng.
    
    Ở đây, lớp UserDetailsServiceImpl và UserRepository là các thành phần của ứng dụng để thực hiện việc xác thực
    và ủy quyền. Khi người dùng đăng nhập vào ứng dụng, Spring Security sẽ sử dụng đối tượng AuthenticationProvider
    để xác thực thông tin đăng nhập của người dùng. Nếu xác thực thành công, Spring Security sẽ sử dụng đối tượng 
    UserDetails để xác định quyền hạn của người dùng và thực hiện các hoạt động ủy quyền tương ứng.


vi,ProviderMAnager,decisionManager là gì.   
    
    ProviderManager và AccessDecisionManager là hai thành phần quan trọng trong Spring Security, 
    chịu trách nhiệm cho việc xác thực người dùng và quyết định xem người dùng có được truy cập vào tài nguyên 
    hay không.
    
    ProviderManager: Là một AuthenticationManager có khả năng chấp nhận danh sách các AuthenticationProvider 
    khác nhau và sử dụng chúng để xác thực người dùng. Mỗi AuthenticationProvider sẽ xác thực người dùng 
    với một phương pháp cụ thể (ví dụ: xác thực bằng tên đăng nhập và mật khẩu, xác thực bằng mã thông báo, ...).
    Nếu một AuthenticationProvider không xác thực được người dùng, ProviderManager sẽ tiếp tục đến 
    AuthenticationProvider tiếp theo cho đến khi người dùng được xác thực thành công hoặc toàn bộ 
    AuthenticationProvider đều thất bại.
    Ví dụ:
    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
        @Autowired
        private CustomUserDetailsService userDetailsService;
     
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        }
     
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
     
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }
    }
    Ở đây, authenticationManagerBean() trả về một ProviderManager được cấu hình để sử dụng CustomUserDetailsService
    để xác thực người dùng và BCryptPasswordEncoder để mã hóa mật khẩu.
    
    AccessDecisionManager: Là một thành phần quan trọng của Spring Security, được sử dụng để đánh giá quyền 
    truy cập của người dùng đến tài nguyên (ví dụ: trang web, API, ...) dựa trên thông tin xác thực của người dùng
    Nó kiểm tra xem người dùng có đủ quyền để truy cập tài nguyên đó hay không.
    Ví dụ:
    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
        @Autowired
        private CustomUserDetailsService userDetailsService;
     
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .and().formLogin();
        }
     
        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/resources/**");
        }
     
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        }
     
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
     
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }
    }
    
    Trong ví dụ này, ProviderManager và DecisionManager được sử dụng thông qua việc cấu hình AuthenticationManager
    trong phương thức configure(AuthenticationManagerBuilder auth).
    
    AuthenticationManager là một interface cốt lõi trong Spring Security và được sử dụng để thực hiện xác thực 
    người dùng. Nó cung cấp phương thức authenticate(Authentication authentication) để xác thực thông tin 
    đăng nhập của người dùng.
    
    Trong phương thức configure(AuthenticationManagerBuilder auth), chúng ta đang cấu hình AuthenticationManager
    bằng cách sử dụng đối tượng CustomUserDetailsService để lấy thông tin người dùng từ cơ sở dữ liệu và sử dụng
    PasswordEncoder để mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu. Sau đó, AuthenticationManager sẽ sử dụng
    thông tin xác thực này để đối chiếu với thông tin đăng nhập của người dùng để xác thực họ.
    
    Trong phương thức authenticationManagerBean(), chúng ta đang tạo một đối tượng AuthenticationManager để được
    sử dụng trong các phương thức khác của ứng dụng, chẳng hạn như khi xác thực thông tin đăng nhập của người dùng
    trong một API hoặc phương thức xử lý yêu cầu khác.
    Trong đoạn mã này, phương thức authenticationManagerBean() được ghi đè để cung cấp AuthenticationManager 
    trong Spring Security. AuthenticationManager đóng vai trò quan trọng trong việc xác thực người dùng và quản lý
    các thông tin xác thực. Khi cấu hình Spring Security, chúng ta có thể sử dụng phương thức này để có thể 
    truy cập đến AuthenticationManager bằng cách inject nó vào các bean khác.
    
    Với việc sử dụng authenticationManagerBean(), chúng ta có thể sử dụng nó để xác thực người dùng trong 
    các trường hợp khác nhau, chẳng hạn như trong RESTful API hoặc trong giao diện web truyền thống.


1,@EnableWebSecurity;
là một annotation trong Spring Security framework,
nó được sử dụng để bật tính năng bảo mật web trên ứng dụng Spring.
Khi chúng ta sử dụng @EnableWebSecurity,
chúng ta có thể định nghĩa cấu hình bảo mật trên lớp WebSecurityConfigurerAdapter,
để quản lý quyền truy cập và xác thực người dùng đối với các tài nguyên trên ứng dụng web.

2, tìm hiểu về lớp WebSecurityConfigurerAdapter.
đây là một abtract class dùng trong việc thiết thiết lập cấu hình cũng như cơ chế bảo mật.
Khi kế thừa lớp WebSecurityConfigurerAdapter trong Spring Security,
ta có thể cấu hình các chức năng bảo vệ trong ứng dụng web, bao gồm:

    a, Thiết lập quyền truy cập: sử dụng phương thức configure(HttpSecurity http) để
     xác định các quyền truy cập của người dùng tới các tài nguyên của ứng dụng web.

    b, Thiết lập đăng nhập: sử dụng phương thức configure(HttpSecurity http) để
    cấu hình xác thực đăng nhập, bao gồm hình thức xác thực như HTTP Basic hoặc Form Login.

    c, Thiết lập phân quyền: sử dụng phương thức configure(AuthenticationManagerBuilder auth) để
    thiết lập các thông tin về người dùng và phân quyền.

    d, Thiết lập mã hóa mật khẩu: sử dụng phương thức configure(AuthenticationManagerBuilder auth) để
    xác định cách mã hóa mật khẩu của người dùng.

    e, Thiết lập xác thực nhiều yếu tố (multi-factor authentication):
    sử dụng phương thức configure(HttpSecurity http) để cấu hình các yếu tố xác thực như mã OTP (One-Time Password).

    f, Thiết lập logout: sử dụng phương thức configure(HttpSecurity http) để cấu hình đăng xuất người dùng
    khỏi ứng dụng web.

    g, Thiết lập các cấu hình khác: sử dụng các phương thức khác của lớp WebSecurityConfigurerAdapter
    để thiết lập các cấu hình khác như mở rộng các cấu hình mặc định của Spring Security,
    cấu hình truy cập tài nguyên tĩnh, ...

Dưới đây là một số tính chất nổi bật của lớp WebSecurityConfigurerAdapter:

    a, Cho phép ta override các phương thức của lớp này để cấu hình bảo mật cho ứng dụng web của mình.
    b, Cung cấp cho ta các cấu hình mặc định cho các phương thức bảo mật như HttpBasic,
    Form Login, Remember Me, CSRF, Logout và đăng ký UserDetailsService.
    c,Cho phép ta sử dụng các annotation như @EnableWebSecurity, @EnableGlobalMethodSecurity,
    @Order và @Configuration trên lớp của mình để cấu hình bảo mật cho ứng dụng web.
    d, Tự động cấu hình Spring Security filter chain trên ứng dụng web của ta.
    e, Cho phép ta sử dụng Spring Security OAuth2, SAML2 và LDAP để
    xác thực người dùng trong ứng dụng web của mình.

3,lớp UserDetailsService trong security của spring boot
    Lớp UserDetailsService được sử dụng trong Spring Security để xác thực người dùng.
    Khi một người dùng cố gắng đăng nhập vào ứng dụng của bạn,
    thông tin đăng nhập sẽ được chuyển đến UserDetailsService để kiểm tra xem người dùng có tồn tại hay không.
    Lớp UserDetailsService đóng vai trò cung cấp thông tin người dùng cho Spring Security
    Nó được sử dụng để lấy thông tin người dùng từ cơ sở dữ liệu hoặc bất kỳ nguồn dữ liệu nào khác.
    Nó cung cấp một phương thức loadUserByUsername()để trả về một đối tượng UserDetails
    cho người dùng tương ứng với tên đăng nhập được cung cấp.
    Đối tượng UserDetails chứa thông tin về người dùng như
    tên đăng nhập,mật khẩu, quyền truy cập và các thông tin khác.
    Nó được sử dụng bởi Spring Security để thực hiện xác thực và kiểm tra phân quyền người dùng
    khi họ cố gắng truy cập vào các tài nguyên được bảo vệ.

    var user1 = User.withUsername("hungnh").password("123").authorities("read").build();
    Dòng code này sử dụng để tạo ra một đối tượng User trong Spring Security.
    Cụ thể, nó sử dụng method tĩnh withUsername() để thiết lập tên đăng nhập cho người dùng (hungnh),
    sử dụng method password() để thiết lập mật khẩu cho người dùng (123),
    và sử dụng method authorities() để thiết lập các quyền (read).

    Sau khi thiết lập các thuộc tính của đối tượng User,
    method build() được sử dụng để trả về một đối tượng User đã được tạo.
    Đối tượng User này có thể được sử dụng để xác thực và phân quyền trong ứng dụng Spring Security.

4,tìm hiểu về builder partern
    Builder Pattern là một kiểu thiết kế phần mềm cho phép tạo ra một đối tượng phức tạp
    bằng cách sử dụng một chuỗi các hàm setter và method chaining để thiết lập các thuộc tính của đối tượng.
    Khi tạo ra một đối tượng bằng Builder Pattern, bạn có thể chỉ định một vài thuộc tính bắt buộc
    và bỏ qua những thuộc tính khác, trong khi vẫn đảm bảo tính chính xác và đầy đủ của đối tượng.
    Điều này giúp cho việc tạo đối tượng trở nên dễ dàng hơn và giảm thiểu khả năng mắc phải lỗi khi tạo đối tượng.


5,Đoạn mã return new InMemoryUserDetailsManager(user1, user2);
    có ý nghĩa là tạo ra một đối tượng InMemoryUserDetailsManager với danh sách các người dùng
    được cung cấp trong đối số.

    InMemoryUserDetailsManager là một lớp cung cấp các phương thức để quản lý danh sách người dùng
    trong bộ nhớ của ứng dụng. Trong đoạn mã này, các người dùng user1 và user2 được cung cấp cho đối tượng
    InMemoryUserDetailsManager để quản lý và xác thực trong ứng dụng.
    Khi phương thức được gọi, đối tượng InMemoryUserDetailsManager sẽ trả về danh sách các người dùng đã
    được cấu hình.

6, Lớp PasswordEncoder trong Spring Security là một interface,
    được sử dụng để mã hóa mật khẩu người dùng.
    Nó được sử dụng để đảm bảo rằng các mật khẩu được lưu trữ trong cơ sở dữ liệu của ứng dụng được mã hóa
    để đảm bảo tính bảo mật.
    Spring Security cung cấp một số lớp implementation của PasswordEncoder interface như sau:

    a, BCryptPasswordEncoder: mã hóa mật khẩu sử dụng thuật toán BCrypt
    b, NoOpPasswordEncoder: không mã hóa mật khẩu, được sử dụng cho mục đích kiểm tra và xác thực mật khẩu trong quá
    trình phát triển ứng dụng
    c, Pbkdf2PasswordEncoder: mã hóa mật khẩu sử dụng thuật toán PBKDF2
    d, SCryptPasswordEncoder: mã hóa mật khẩu sử dụng thuật toán SCrypt
    PasswordEncoder có tính chất giúp ứng dụng xác định được cách mã hóa và giải mã mật khẩu của người dùng.
    Việc sử dụng một mã hóa mật khẩu mạnh sẽ giúp tăng tính bảo mật cho ứng dụng của bạn.
    Khi người dùng đăng nhập, mật khẩu của họ sẽ được mã hóa và so sánh với mật khẩu đã được mã hóa
    trong cơ sở dữ liệu.
    Nếu hai giá trị tương đương nhau, người dùng sẽ được cho phép truy cập vào ứng dụng.

7,  cơ chế authentication http.basic, khác gì với http.formLogin
    
    Trong Spring Security, cơ chế xác thực Basic Authentication và Form Authentication là 
    hai phương thức khác nhau để xác thực người dùng.
    
    a, Basic Authentication: Đây là phương thức đơn giản nhất để xác thực người dùng trên HTTP. 
    Phương thức này sử dụng Header "Authorization" để gửi thông tin đăng nhập của người dùng. 
    Trong Spring Security, để sử dụng phương thức xác thực này, bạn cần cấu hình httpBasic() 
    trong configure(HttpSecurity http) method của class extends WebSecurityConfigurerAdapter.
    ví dụ:
    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        }
    
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("USER");
        }
    }


    b, Form Authentication: Đây là phương thức xác thực thông dụng hơn, 
    người dùng sẽ nhập thông tin đăng nhập (username và password) vào một form trên trình duyệt. 
    Sau đó, form này sẽ được gửi đến server để xác thực thông tin. 
    Trong Spring Security, để sử dụng phương thức xác thực này, bạn cần cấu hình formLogin() 
    trong configure(HttpSecurity http) method của class extends WebSecurityConfigurerAdapter.
    ví dụ:
    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("user")
                    .password(passwordEncoder().encode("password"))
                    .roles("USER");
        }
    
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/admin").hasRole("USER")
                    .and()
                    .formLogin();
        }
    
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }



    Cả hai phương thức xác thực này đều cung cấp các tính năng như phân quyền,
    logout, session management, CSRF protection,... 
    Tuy nhiên, Form Authentication cung cấp nhiều tính năng linh hoạt hơn Basic Authentication.
    
    trong ví dụ của phần SecurityConfig, 
    ví dụ 2: Trong ví dụ này, phương thức configure(HttpSecurity http) sử dụng cơ chế Basic Authentication 
    bằng cách sử dụng phương thức http.httpBasic(). Các yêu cầu sẽ được xác thực bằng cách yêu cầu người
    dùng nhập thông tin đăng nhập trong cửa sổ pop-up, và thông tin đăng nhập được mã hóa và 
    gửi dưới dạng Header Authorization trên mỗi yêu cầu.

    Phương thức configure(AuthenticationManagerBuilder auth) xác định người dùng và mật khẩu được cung cấp  
    cho xác thực người dùng, được lưu trữ trong bộ nhớ.

    ví dụ 3: Ví dụ trên cũng là một cách để cấu hình cơ chế Basic Authentication trong Spring Security, 
    tuy nhiên nó sử dụng UserDetailsService và PasswordEncoder để cung cấp danh sách người dùng và 
    mã hóa mật khẩu thay vì sử dụng phương thức auth.inMemoryAuthentication() trong ví dụ 2.

    Để cung cấp danh sách người dùng, ta sử dụng phương thức inMemoryUserDetailsManager() để trả về một danh sách 
    UserDetails gồm các thông tin về tài khoản người dùng. Sau đó, ta sử dụng phương thức auth.userDetailsService()
    để cung cấp danh sách người dùng cho AuthenticationManagerBuilder.

    Tương tự, ta sử dụng phương thức passwordEncoder() để trả về một PasswordEncoder để mã hóa mật khẩu 
    của người dùng. Phương thức passwordEncoder() này được sử dụng để cấu hình một NoOpPasswordEncoder, 
    tức là không thực hiện bất kỳ mã hóa nào trên mật khẩu. 
    Việc sử dụng NoOpPasswordEncoder không được khuyến khích trong môi trường sản xuất và chỉ nên sử dụng 
    cho mục đích thử nghiệm và phát triển.
    
    ví dụ 4: 
    Trong ví dụ này, chúng ta sử dụng Spring Security để cấu hình cơ chế authentication bằng form login.

    Phương thức configure(HttpSecurity http) được sử dụng để cấu hình các chính sách bảo mật, 
    trong đó ta đang cấu hình để sử dụng cơ chế authentication bằng form login và bất kỳ request nào 
    cũng cần được authenticated.
    PasswordEncoder được sử dụng để mã hóa mật khẩu người dùng trong quá trình xác thực, ở đây 
    chúng ta sử dụng BCryptPasswordEncoder.
    inMemoryUserDetailsManager() là một bean được đăng ký để lưu trữ thông tin người dùng, bao gồm 
    username, password và các quyền hạn (roles) của họ. Trong ví dụ này, ta tạo ra 3 người dùng có username 
    là "hung1", "hung2" và "hung3" và password đều là "123", và tất cả đều có quyền truy cập với role là "USER". 
    Ở đây, password của người dùng được mã hóa bằng cách sử dụng phương thức encode() của PasswordEncoder.
    Về phần @Autowired private PasswordEncoder encoder, nó được sử dụng để tiêm PasswordEncoder 
    vào trong inMemoryUserDetailsManager() khi tạo bean. Điều này có nghĩa là chúng ta sẽ sử dụng 
    BCryptPasswordEncoder để mã hóa mật khẩu của người dùng khi lưu trữ vào bộ nhớ.

    ví dụ5: 
    Ví dụ này là một cách cấu hình bảo mật trong Spring Security sử dụng một DelegatingPasswordEncoder
    để mã hóa mật khẩu của người dùng.

    Cụ thể, phương thức delegatePasswordEnCoder(String encodingType) trả về một đối tượng PasswordEncoder, 
    trong đó sử dụng một DelegatingPasswordEncoder với một tập hợp các PasswordEncoder khác nhau được chỉ định 
    bởi mapping của các encodingType. Điều này có nghĩa là, tùy thuộc vào giá trị của biến encodingType 
    được truyền vào, mật khẩu của người dùng sẽ được mã hóa bằng một trong các loại mã hóa được chỉ định.

    Trong ví dụ này, chúng ta sử dụng PBKDF2 (Password-Based Key Derivation Function 2) để mã hóa mật khẩu 
    người dùng. Để sử dụng phương thức delegatePasswordEnCoder, chúng ta phải khai báo một Bean PasswordEncoder 
    trong cấu hình bảo mật của ứng dụng bằng phương thức passwordEncoder().

    Sau đó, trong phương thức inMemoryUserDetailsManager(), chúng ta sử dụng đối tượng userBuilder 
    để tạo ra ba người dùng có tên đăng nhập và mật khẩu tương ứng. Mật khẩu của mỗi người dùng được mã hóa 
    bằng cách sử dụng phương thức encode() của đối tượng PasswordEncoder đã được khai báo trước đó. 
    Cuối cùng, danh sách người dùng được trả về bởi phương thức inMemoryUserDetailsManager() sẽ được sử dụng 
    trong việc xác thực và phân quyền người dùng của ứng dụng.
    
    a, mã hóa ldap 
    encoders.put("ldap", new LdapShaPasswordEncoder());
    LdapShaPasswordEncoder là một implementation của PasswordEncoder interface trong Spring Security. 
    Nó được sử dụng để mã hóa mật khẩu bằng thuật toán SHA-1 hashing sau đó mã hóa kết quả bằng thuật toán Ldap. 
    Khi mật khẩu được lưu trữ trong LDAP, thì chúng sẽ được mã hóa bằng cách sử dụng LdapShaPasswordEncoder. 
    Khi người dùng đăng nhập, mật khẩu được nhập vào sẽ được mã hóa bằng cách sử dụng cùng một thuật toán 
    LdapShaPasswordEncoder và so sánh với mật khẩu đã được lưu trữ. Nếu cả hai giá trị giống nhau, 
    người dùng được xác thực thành công.

    b,md4 là gì
    encoders.put("MD4", new Md4PasswordEncoder());
    MD4 là một thuật toán băm (hashing algorithm) được sử dụng để mã hóa thông điệp văn bản đầu vào thành 
    một giá trị băm (hash value). MD4 được phát triển bởi Ron Rivest vào năm 1990 và đã bị thay thế bởi các thuật toán băm khác 
    như MD5, SHA-1, SHA-2 và SHA-3 do nhiều lỗ hổng bảo mật được phát hiện.

    Trong đoạn code mà bạn đã chia sẻ, encoders.put("MD4", new Md4PasswordEncoder()); được sử dụng để đăng ký một PasswordEncoder mới,
    sử dụng thuật toán mã hóa MD4. Khi đăng nhập vào hệ thống, mật khẩu của người dùng sẽ được mã hóa bằng thuật toán MD4 trước khi 
    so sánh với mật khẩu đã được mã hóa trong cơ sở dữ liệu.

    c,md5 là gì
    MD5 là một thuật toán băm thông điệp (hash function) được sử dụng rộng rãi trong các ứng dụng bảo mật, 
    trong đó thông điệp đầu vào được chuyển đổi thành một giá trị băm có độ dài cố định. Giá trị băm này 
    thường được sử dụng để lưu trữ mật khẩu của người dùng trong cơ sở dữ liệu mà không cần lưu trữ mật khẩu
    dưới dạng văn bản thô, giúp tăng tính bảo mật. Tuy nhiên, MD5 không còn được coi là an toàn do khả năng 
    va chạm (collision) giữa các giá trị băm.

    Trong ví dụ của bạn, encoders.put("MD5", new MessageDigestPasswordEncoder("MD5")) là để tạo ra 
    một PasswordEncoder sử dụng thuật toán băm MD5 để mã hóa mật khẩu của người dùng trước khi lưu trữ vào
    cơ sở dữ liệu. Tuy nhiên, việc sử dụng MD5 trong các ứng dụng thực tế không được khuyến khích do vấn đề về 
    tính bảo mật như đã nêu ở trên.
    
    d, noop là gì
    encoders.put("noop",  NoOpPasswordEncoder.getInstance());

    TPasswordEncoder là một interface được Spring cung cấp để mã hóa mật khẩu. noop là viết tắt của "no operation",
    nó không mã hóa mật khẩu và chỉ đơn giản là lưu trữ mật khẩu dưới dạng đầu vào.

    Nếu sử dụng noop thì mật khẩu sẽ không được mã hóa và sẽ được lưu trữ dưới dạng plain text. Tuy nhiên, 
    việc lưu trữ mật khẩu dưới dạng plain text không an toàn và không được khuyến khích trong các ứng dụng thực tế.
    
    e,sha1 là gì
    encoders.put("SHA-1", new MessageDigestPasswordEncoder("SHA-1"));
    
    SHA-1 là một thuật toán mã hóa băm (hashing) một chiều (one-way) được sử dụng để tạo ra một giá trị băm duy nhất 
    từ dữ liệu đầu vào. Kết quả của quá trình mã hóa băm SHA-1 là một chuỗi 40 ký tự hệ thập lục phân (hexadecimal)
    duy nhất, được coi là đại diện cho dữ liệu đầu vào. SHA-1 được sử dụng phổ biến trong các ứng dụng bảo mật 
    để mã hóa mật khẩu và xác thực người dùng.

    Trong đoạn mã được đưa ra, encoders.put("SHA-1", new MessageDigestPasswordEncoder("SHA-1")) là để đăng ký 
    một PasswordEncoder   sử dụng thuật toán mã hóa băm SHA-1 cho việc mã hóa mật khẩu. Khi một mật khẩu được 
    mã hóa bằng PasswordEncoder này,   nó sẽ được mã hóa bằng thuật toán SHA-1 và trả về chuỗi ký tự tương ứng
    với giá trị băm của mật khẩu đó.

    f,sha-256 là gì
    encoders.put("SHA-256", new MessageDigestPasswordEncoder("SHA-256"));
    
    Trong ví dụ trên, đoạn mã encoders.put("SHA-256", new LdapShaPasswordEncoder()); có vẻ không chính xác, 
    vì LdapShaPasswordEncoder là một mã hóa đặc biệt được sử dụng trong LDAP (Lightweight Directory Access Protocol), và không phải là mã hóa SHA-256.
    
    Trong Spring Security, để mã hóa mật khẩu theo SHA-256, chúng ta có thể sử dụng lớp StandardPasswordEncoder hoặc MessageDigestPasswordEncoder. Ví dụ:


    g, sha-256 new StandardPasswordEncoder()
    SHA-256 (Secure Hash Algorithm 256) là một thuật toán mã hóa băm (hashing algorithm) dùng để bảo mật thông tin.
    Thuật toán này được sử dụng rộng rãi trong các ứng dụng bảo mật, như xác thực người dùng, xác thực tệp tin, 
    mã hóa dữ liệu, và nhiều hệ thống khác. SHA-256 được thiết kế để sinh ra một giá trị hash độc lập với độ dài
    đầu vào và có độ dài cố định là 256 bit, cho phép việc lưu trữ và truyền tải giá trị hash dễ dàng hơn
    so với các thuật toán mã hóa băm khác.

   

