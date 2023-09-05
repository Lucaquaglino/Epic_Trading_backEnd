package EpicTrading;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import EpicTrading.entities.user.NewUserPayload;
import EpicTrading.entities.user.Role;
import EpicTrading.entities.user.User;
import EpicTrading.entities.user.UserRepository;
import EpicTrading.entities.user.UserService;

@Component
public class UserRunner implements CommandLineRunner {

	@Autowired
	UserService uS;

	@Autowired
	UserRepository uR;

	@Override
	public void run(String... args) throws Exception {

		Faker faker = new Faker(new Locale("it"));

		List<User> utentiDb = uR.findAll();
		if (utentiDb.isEmpty()) {

			for (int i = 0; i < 10; i++) {
				String username = faker.funnyName().name();
				String name = faker.name().firstName();
				String surname = faker.name().lastName();
				String email = faker.internet().emailAddress();
				String password = "1234";
				Role role = (i % 2 == 0) ? Role.USER : Role.ADMIN;

				NewUserPayload utente = new NewUserPayload(username, name, surname, email, password, role);
				uS.save(utente);

			}
		}

	}

}