package cn.disscode.app.securrity.config;

import cn.disscode.app.securrity.CustomAuthenticationEntryPoint;
import cn.disscode.app.securrity.filter.JwtAuthenticationTokenFilter;
import cn.disscode.app.securrity.service.JwtUserDetailsServiceImpl;
import cn.disscode.app.securrity.handler.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Spring Security 配置类
 *
 * @Author: dumplingBao
 * @Date: 2021/9/1
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtUserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    /**
     * 从容器中取出 AuthenticationManagerBuilder，执行方法里面的逻辑之后，放回容器
     * @param authenticationManagerBuilder
     * @throws Exception
     */
    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().sessionManagement()
                // 基于token
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                //跨域请求会先进行一次options（预检）请求，允许 options 请求
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // 角色校验时，会自动拼接 "ROLE_"
                .antMatchers("/role/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/login","/register").permitAll()
                .antMatchers("/noAuth/**").permitAll()
                .antMatchers("/test/**").permitAll()
                .antMatchers("/swagger-ui/**","/swagger-resources/**","/v3/**","/swagger-ui/index.html/**").permitAll()
                .anyRequest().authenticated()   // 任何请求,登录后可以访问
                .and().headers().cacheControl();

        /**
         * 在 UsernamePasswordAuthenticationFilter 之前添加 JwtAuthenticationTokenFilter
         */
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // 处理异常情况：认证失败和权限不足
        http.exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint).accessDeniedHandler(customAccessDeniedHandler);
    }

    /**
     * 跨域设置
     * @return
     */
    @Bean
    public CorsFilter corsFilter(){
        // cors配置信息
        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowCredentials(true);// 是否发送cookie信息
        /** 白名单设置
        List<String> list = new ArrayList<String>();
        list.add("http://www.disscode.cn");
        cors.setAllowedOrigins(list);
         */
        cors.addAllowedOrigin("*");// 允许的域
        cors.addAllowedHeader("*");// 允许的请求方式
        cors.addAllowedMethod("*");// 允许的头信息

        // 映射路径
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", cors);
        return new CorsFilter(configurationSource);
    }
}
