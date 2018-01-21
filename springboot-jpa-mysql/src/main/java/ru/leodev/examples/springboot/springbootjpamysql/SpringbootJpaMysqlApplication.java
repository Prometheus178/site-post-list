package ru.leodev.examples.springboot.springbootjpamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import ru.leodev.examples.springboot.springbootjpamysql.dao.UserRepository;
import ru.leodev.examples.springboot.springbootjpamysql.model.User;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringbootJpaMysqlApplication {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    DataSource dataSource; // inject datasource to check is used Hikari?

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaMysqlApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return new CommandLineRunner() {
            // начиная со spring boot 1.5 ридонли над методом который вызывает репозиторий нужен обязательно
            // что бы не закрывалась сессия.
            @Override
            @Transactional(readOnly = true)
            public void run(String... args) throws Exception {

                System.out.println("DATASOURCE = " + dataSource);

                System.out.println("\n1.findAll()...");
                for (User user : repository.findAll()) {
                    System.out.println(user);
                }

                System.out.println("\n2.findByEmail(String email)...");
                for (User user : repository.findByEmail("111@leodev.ru")) {
                    System.out.println(user);
                }

                System.out.println("\n3.findByDate(Date date)...");
                for (User user : repository.findByDate(sdf.parse("2018-03-22"))) {
                    System.out.println(user);
                }

                // For Stream, need @Transactional
                System.out.println("\n4.findByEmailReturnStream(@Param(\"email\") String email)...");
                try (Stream<User> stream = repository.findByEmailReturnStream("333@leodev.ru")) {
                    stream.forEach(System.out::println);
                }

                System.out.println("Done!");
            }
        };


    }
}
