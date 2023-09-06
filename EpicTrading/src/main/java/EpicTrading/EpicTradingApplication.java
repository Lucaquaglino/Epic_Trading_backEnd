package EpicTrading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication

public class EpicTradingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpicTradingApplication.class, args);
	}

}
