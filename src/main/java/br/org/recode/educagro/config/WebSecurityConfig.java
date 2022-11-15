package br.org.recode.educagro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.org.recode.educagro.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        //Início Liberação das rotas padrão do site
        	.antMatchers("/").permitAll()
        	.antMatchers("/home").permitAll()
        	.antMatchers("/educagro-dicaspais").permitAll()
        	.antMatchers("/professores/cadastro").permitAll()
        	.antMatchers("/educagro-dicasprof").permitAll()
        	.antMatchers("/alfabetizacao").permitAll()
        	.antMatchers("/portugues").permitAll()
        	.antMatchers("/matematica").permitAll()
        	.antMatchers("/sobre").permitAll()
        //Fim da liberação de rotas padrão
            .antMatchers("/admin/adminlte/**").permitAll()
            .antMatchers("/admin/img/**").permitAll()
            .antMatchers("/admin/js/**").permitAll()
            .antMatchers("/admin/plugins/**").permitAll()
//            .antMatchers("/**/cadastrar").hasAuthority(Perfil.ADMIN.toString())
//            .antMatchers("/**/editar").hasAuthority(Perfil.ADMIN.toString())
//            .antMatchers("/**/excluir").hasAuthority(Perfil.ADMIN.toString());
   
            .antMatchers("/css/**").permitAll()
            .antMatchers("/js/**").permitAll()
            .antMatchers("/fonts/**").permitAll()
            .antMatchers("/images/**").permitAll()
            .anyRequest().authenticated();//Comentar essa linha para criar um usuário e testar o acesso

        http.formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/dashboard")
            .permitAll();   
        
        http.logout()
        .logoutRequestMatcher(
            new AntPathRequestMatcher("/logout", "GET")
        )
        .logoutSuccessUrl("/home");
        
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl)
            .passwordEncoder(new BCryptPasswordEncoder());
    }
    
}
