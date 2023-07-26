package tmd.pop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tmd.pop.entity.Person;
import tmd.pop.repository.PersonRepository;
import tmd.pop.service.PersonService;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

    private final PersonService personService;

    public Application(PersonService personService) {
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }

    //    @Bean
    CommandLineRunner commandLineRunner(PersonRepository personRepository) {
        return args -> {
            Person person = Person.builder()
                    .name("Name")
                    .surname("Surname")
                    .birthYear(LocalDate.of(1970, 1, 12))
                    .build();
            personRepository.save(person);
        };
    }

}
