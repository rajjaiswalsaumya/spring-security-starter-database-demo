package org.cdac;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.headers().cacheControl().contentTypeOptions()
				.httpStrictTransportSecurity().and().authorizeRequests()
				.antMatchers("/", "/static/**", "/home").permitAll()
				.anyRequest().authenticated().and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/hello")
				.failureUrl("/login?error").permitAll().and().logout()
				.permitAll();
	}

	@Configuration
	protected static class AuthenticationConfiguration extends
			GlobalAuthenticationConfigurerAdapter {

		@Autowired
		DataSource dataSource;

		@Override
		public void init(final AuthenticationManagerBuilder auth)
				throws Exception {
			auth.jdbcAuthentication().withDefaultSchema()
					.dataSource(this.dataSource);
			// .dataSource(this.dataSource)
			// .usersByUsernameQuery(
			// "select username,password,enabled from users where username=? ")
			// .authoritiesByUsernameQuery(
			// "select username,role from authorities a,users u where u.roleid=a.roleid and username=?");
		}
	}
}
