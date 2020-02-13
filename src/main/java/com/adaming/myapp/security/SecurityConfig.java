package com.adaming.myapp.security;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	//@Qualifier(value="datasourceBean")
	private DataSource datasourceBean;

	public DataSource getDatasourceBean() {
		return datasourceBean;
	}

	public void setDatasourceBean(DataSource datasourceBean) {
		this.datasourceBean = datasourceBean;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasourceBean)//.rolePrefix("Role")
				.usersByUsernameQuery("select username,password, activated from users where username=?")
				.authoritiesByUsernameQuery("select u.username, r.rolename from users u, roles r  where u.idUser = r.idUser and u.username =? ");
       // auth.inMemoryAuthentication().withUser("admin").authorities("Role_Admin").password("admin");
		//super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.httpBasic().and().authorizeRequests().antMatchers("/Etudiant/Ajout").permitAll();//hasAuthority("Role_Admin");
		http.httpBasic().and().authorizeRequests().antMatchers("/Matiere/Ajout").hasAuthority("Admin");//("Role_Admin");//hasAuthority("Admin");
		http.formLogin().loginPage("/login").passwordParameter("password").usernameParameter("username")
				.defaultSuccessUrl("/HomeController/home").failureUrl("/erreur");
		//super.configure(http);
	}

}
