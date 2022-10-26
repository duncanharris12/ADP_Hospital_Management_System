package za.ac.cput.Security;
//This is a security configure
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class SecurityConfig  {

    @Bean
    public UserDetailsService users() {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(passwordEncoder().encode("12345"))
                .roles("USER")
                .build());

        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("54321"))
                .roles("USER","ADMIN")
                .build());

        return manager;

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.httpBasic()
                .and()
                .authorizeRequests()

                //patient authentication
                .antMatchers(HttpMethod.POST,"/patient/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/patient/deletePatient/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/patient/readPatient").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/patient/all/").hasRole("USER")


                //testPatient authentication
                .antMatchers(HttpMethod.POST,"/testPatient/save_testPatient").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/testPatient/readTestPatient/").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/testPatient/deleteTestPatient/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/testPatient/getTestPatients").hasRole("USER")

                //department authentication
                .antMatchers(HttpMethod.POST,"/department/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/department/readDepartment/").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/department/deleteDepartment/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/department/getAll").hasRole("USER")

                //doctor authentication
                .antMatchers(HttpMethod.POST,"/doctor/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/doctor/readDoctor/").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/doctor/deleteDoctor/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/doctor/getAll").hasRole("USER")

                //Appointment authentication
                .antMatchers(HttpMethod.POST,"/appointment/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/appointment/deleteAppointment/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/appointment/readAppointment").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/appointment/getAll/").hasRole("USER")


                //Laboratory authentication
                .antMatchers(HttpMethod.POST,"/laboratory/save_laboratory").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/laboratory/readLaboratory/").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/laboratory/deleteLaboratory/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/laboratory/getAllLaboratory").hasRole("USER")

                //medication authentication
                .antMatchers(HttpMethod.POST,"/medication/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/medication/readMedication/").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/medication/deleteMedication/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/medication/getAll").hasRole("USER")

                //testResults authentication
                .antMatchers(HttpMethod.POST,"/testResults/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/testResults/readTestResults/").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/testResults/deleteTestResults/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/testResults/getAll").hasRole("USER")

                //Receptionist authentication
                .antMatchers(HttpMethod.POST,"/receptionist_type/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/receptionist_type/read").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/receptionist_type/delete").hasRole("ADMIN")


                .and()
                .csrf().disable()
                .formLogin().disable();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}