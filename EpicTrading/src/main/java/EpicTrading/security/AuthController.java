package EpicTrading.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import EpicTrading.entities.user.LoginSuccessfullPayload;
import EpicTrading.entities.user.NewUserPayload;
import EpicTrading.entities.user.User;
import EpicTrading.entities.user.UserLoginPayload;
import EpicTrading.entities.user.UserService;
import EpicTrading.exceptions.UnauthorizedException;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UserService uS;

	@Autowired
	JWTTools jwtTools;

	@Autowired
	PasswordEncoder bcrypt;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUtente(@RequestBody NewUserPayload body) {

		body.setPassword(bcrypt.encode(body.getPassword()));
		User created = uS.save(body);

		return created;
	}

	@PostMapping("/login")
	public LoginSuccessfullPayload login(@RequestBody UserLoginPayload body) {

		User user = uS.findByEmail(body.getEmail());

		if (bcrypt.matches(body.getPassword(), user.getPassword())) {
			String token = jwtTools.createToken(user);
			return new LoginSuccessfullPayload(token);

		} else {
			throw new UnauthorizedException("Credenziali non valide");
		}
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logout() {
		System.out.println("Logout effettuato con successo");
		return ResponseEntity.ok("Logout effettuato con successo");

	}
}
