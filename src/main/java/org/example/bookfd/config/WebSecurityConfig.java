package org.example.bookfd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers( "/res","/reg","/authoriz","/Questions","/ff","/Books","/ListTestsNames","/AllBooks","/bv","/create", "/vv","/reg","/css/**","/images/**","/GetIdBook","/Photo","/websocket","/GetAllUsers","/getChatsInfo","/SelectUsers").permitAll()
                    .antMatchers(HttpMethod.POST,"/reg","/registration_mobile","/AddNewFileAndroid","/addtest","/addquestion","/add_result","/Verification","/sendMessage","/addGroup").permitAll()
                    .antMatchers(HttpMethod.POST, "/xv").hasAuthority("ADMIN")
                    .anyRequest().authenticated().and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .csrf().disable()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select login, password, active from autoriz where login=?")
                .authoritiesByUsernameQuery("select login, role from autoriz where login=?");
    }
}