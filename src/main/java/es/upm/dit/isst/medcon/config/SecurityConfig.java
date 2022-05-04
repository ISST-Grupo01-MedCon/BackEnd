package es.upm.dit.isst.medcon.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource ds;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests() //Define who can access the resources

        .antMatchers("/static/css/**", "/static/js/**", "/*.svg", "/*.png", "/*.ico", "/*.json", "/*.mp3", "/index.html").permitAll()
        .antMatchers("/paciente/*").permitAll()
        .antMatchers("/sala_de_espera").permitAll()
        .antMatchers("/").permitAll()
        .antMatchers("/medico/login").permitAll()

        .antMatchers("/medico/lista_siguientes_pacientes").hasAnyRole("MEDICO")
        .antMatchers("/medico/lista_pacientes_descartados").hasAnyRole("MEDICO")
        .antMatchers("/medico/lista_completa_pacientes").hasAnyRole("MEDICO")
        .antMatchers("/medico/detalles_paciente/**").hasAnyRole("MEDICO")
        .antMatchers("/medico/nueva_consulta_paciente/**").hasAnyRole("MEDICO")
        .antMatchers("/medico/recetas_paciente/").hasAnyRole("MEDICO")

        .anyRequest().authenticated().and()
        .formLogin().loginPage("/medico/login")
        .loginProcessingUrl("/medico/autenticar").permitAll()
        .defaultSuccessUrl("/home", true)
        .and().logout().logoutUrl("/medico/logout")
        .and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/h2-console/**"); 
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(ds)
        .usersByUsernameQuery("select usuario as username, contraseña as password, TRUE as enabled from medico where usuario=?")
        .authoritiesByUsernameQuery("select usuario as username, 'MEDICO' as authority from medico where usuario=?");
    }

}