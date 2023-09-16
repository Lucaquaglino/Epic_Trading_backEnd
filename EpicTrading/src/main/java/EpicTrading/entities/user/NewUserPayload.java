package EpicTrading.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewUserPayload {

	private String username;
	private String name;
	private String surname;
	private String email;
	private String password;
	private Role role;
	private String phoneNumber;

}
