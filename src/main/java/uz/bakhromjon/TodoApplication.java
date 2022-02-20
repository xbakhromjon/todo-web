package uz.bakhromjon;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.bakhromjon.entity.user.AuthUser;
import uz.bakhromjon.repository.UserRepository;

import java.util.Arrays;

@SpringBootApplication
public class TodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

}
