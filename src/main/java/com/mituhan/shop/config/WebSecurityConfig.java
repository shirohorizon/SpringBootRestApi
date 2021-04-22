package com.mituhan.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig {

//	@Autowired
//	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//
////	antMatchers(): khai báo đường dẫn của request
////	permitAll(): cho phép tất cả các user đều được phép truy cập.
////	hasRole(roleName): chỉ cho phép các user có GrantedAuthority là ROLE_roleName mới được phép truy cập
//
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/register").permitAll()
//				.antMatchers("/").permitAll()
//				.antMatchers("/contact/add").permitAll()
//                .antMatchers("/cart").hasRole("MEMBER")
//				.antMatchers("/user/profile/**").hasRole("MEMBER")
//                .antMatchers("/admin").hasRole("ADMIN")
//                .and()
//            .formLogin()
//            	.loginPage("/login")
//            	.usernameParameter("username")
//            	.passwordParameter("password")
//            	.defaultSuccessUrl("/")
//            	.failureUrl("/login?error")
//            	.and()
//			.logout()
//				.logoutUrl("/logout")
//				.logoutSuccessUrl("/")
//				.and()
//        	.exceptionHandling()
//    			.accessDeniedPage("/403");
//    }
	
}
