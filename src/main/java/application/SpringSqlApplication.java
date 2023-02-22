package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import repositories.CustomerRepository;

@SpringBootApplication
public class SpringSqlApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(PgAppRunner.class, args);
    }

    @Override
    public void run(ApplicationArguments args){}
}
