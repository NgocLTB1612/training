package com.bookpack;

import com.bookpack.audit.SpringSecurityAuditorAware;
import com.bookpack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bookpack.entity.Book;
import com.bookpack.entity.Category;
import com.bookpack.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.bookpack.repository")
@EntityScan(basePackages = "com.bookpack.entity")
@ComponentScan(basePackageClasses = Book.class)
@ComponentScan(basePackageClasses = Category.class)
@ComponentScan(basePackageClasses = User.class)
public class Bmp1Application implements CommandLineRunner {

    @Bean

    public AuditorAware<String> auditorAware() {

        return new SpringSecurityAuditorAware();

    }

@Bean
    public WebMvcConfigurer corsConfigurer (){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200")
                        .allowedMethods("/*")
                        .allowedHeaders("Access-Control-Allow-Origin")
                        .exposedHeaders("Access-Control-Allow-Origin")
                        .allowCredentials(false).maxAge(3600);;;
            }
        };
    }

    public static void main(String[] args) {

        SpringApplication.run(Bmp1Application.class, args);

    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

    ;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("linh") == null) {
            User user = new User();
            user.setUserName("Linh");
            user.setPassword(passwordEncoder.encode("12345678"));
            userRepository.save(user);
            System.out.println(user);
        }
    }
	/*	@PostConstruct
	public void initUsers(){
		List<User> users = Stream.of(
				new User(102, "user1", "user1@gmail.com", "123456"),
				new User(103, "user2", "user2@gmail.com", "123456"),
				new User(104, "user3", "user3@gmail.com", "123456")
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}*/


}