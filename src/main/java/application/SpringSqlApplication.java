package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import repositories.CustomerRepository;

@SpringBootApplication
@ComponentScan("repositories")
public class SpringSqlApplication implements ApplicationRunner {
    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSqlApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        customerRepository.test();

    }
}
