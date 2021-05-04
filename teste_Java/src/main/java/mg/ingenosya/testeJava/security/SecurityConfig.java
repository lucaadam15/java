package mg.ingenosya.testeJava.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import mg.ingenosya.testeJava.classe.Utilisateur;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	String loginPage = "/utilisateur/connection";
    String logoutPage = "/logout";
	
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) {
		 bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        try {
	        	auth.jdbcAuthentication().dataSource(dataSource).authoritiesByUsernameQuery(
	    				"select username as principal, mdp as credentials, enabled as enabled from users where username=?")
	    				.authoritiesByUsernameQuery(
	    						"select username as principal, role as role from user_role where username=?")
	    				.rolePrefix("ING_").passwordEncoder(bCryptPasswordEncoder);
			} catch (Exception e) {
				e.printStackTrace();
			}
	 }
	 
	 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		 http.cors().disable()
					.authorizeRequests().antMatchers("/**", "/").permitAll().antMatchers(loginPage).permitAll().anyRequest()
		            .authenticated().and().httpBasic().and().csrf().disable()
		            .formLogin().loginPage(loginPage).loginPage("/")
		            .loginProcessingUrl("/login")
	                .defaultSuccessUrl("/", true)
		            .failureUrl("/login?error=true").usernameParameter("pseudo").passwordParameter("mdp")
		            .and().logout().deleteCookies("JSESSIONID").logoutRequestMatcher(new AntPathRequestMatcher(logoutPage))
		            .logoutSuccessUrl(loginPage).and().exceptionHandling()
		            .and().rememberMe().key("uniqueAndSecret");
	}
	
	 
	 @Override
	 public void configure(WebSecurity web) throws Exception {
		 web.ignoring()
		 .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/templates/**");
		 }
}
