package EpicTrading;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		Faker faker = new Faker(new Locale("it"));

		List<User> userDb = uR.findAll();
		if (userDb.isEmpty()) {

			for (int i = 0; i < 100; i++) {
				String username = faker.funnyName().name();
				String name = faker.name().firstName();
				String surname = faker.name().lastName();
				String email = faker.internet().emailAddress();
				String password = "1234";
				// aggiunta ruolo casuale
				Role role = (i % 2 == 0) ? Role.USER : Role.ADMIN;
				// bcrypt password
				String encodedPassword = passwordEncoder.encode(password);

				NewUserPayload user = new NewUserPayload(username, name, surname, email, encodedPassword, role);
				uS.save(user);

			}
		}

	}

}