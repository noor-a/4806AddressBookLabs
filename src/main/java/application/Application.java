package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return(args -> {
            repository.save(new BuddyInfo("Noor","Ottawa", "613" ));
            repository.save(new BuddyInfo("Ncho", "Hamilton", "289"));
            repository.save(new BuddyInfo("Sarfo", "Stevenage", "01438"));

            log.info("Buddies found with findAll:");
            log.info("------------------------------");
            for(BuddyInfo b:repository.findAll()){
                log.info(b.toString());
            }
            log.info("");

            log.info("Customer found with findByName('Ncho'):");
            log.info("--------------------------------------------");
            repository.findByName("Ncho").forEach(ncho -> {
                log.info(ncho.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        });
    }
}
