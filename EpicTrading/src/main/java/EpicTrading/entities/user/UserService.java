package EpicTrading.entities.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import EpicTrading.entities.transaction.Transaction;
import EpicTrading.exceptions.BadRequestException;
import EpicTrading.exceptions.NotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository uR;

	// SALVA NUOVO UTENTE + ECCEZIONE SE VIENE USATA LA STESSA EMAIL
	public User save(NewUserPayload body) {
		uR.findByEmail(body.getEmail()).ifPresent(user -> {
			throw new BadRequestException("L'email " + body.getEmail() + " è gia stata utilizzata");
		});
		User newUser = new User(body.getUsername(), body.getName(), body.getSurname(), body.getEmail(),
				body.getPassword(), body.getRole());
		return uR.save(newUser);
	}

	// TORNA LA LISTA DEGLI UTENTI
	public List<User> getAllUsers() {
		return uR.findAll();
	}

	// CERCA UTENTE TRAMITE ID
	public User findById(UUID id) throws NotFoundException {
		return uR.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	// CERCA E MODIFICA UTENTE TRAMITE ID
	public User findByIdAndUpdate(UUID id, NewUserPayload body) throws NotFoundException {
		User found = this.findById(id);
		found.setName(body.getName());
		found.setSurname(body.getSurname());
		found.setEmail(body.getEmail());
		found.setPhoneNumber(body.getPhoneNumber());
		found.setUsername(body.getUsername());
		return uR.save(found);
	}

	public User findByIdAndUpdateTransactions(UUID id, Transaction newTransaction) throws NotFoundException {
		User user = uR.findById(id).orElseThrow(() -> new NotFoundException(id));

		// Imposta l'utente sulla nuova transazione
//		newTransaction.setUserId(user.getId());

		// Aggiungi la nuova fattura all'array di fatture del cliente
		user.getTransaction().add(newTransaction);

		// Salva il cliente aggiornato nel repository
		return uR.save(user);
	}

	public User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();

		if (principal instanceof User) {
			User user = (User) principal;
			String currentUserName = user.getName();
			Optional<User> userOptional = uR.findByName(currentUserName);

			if (userOptional.isPresent()) {
				return userOptional.get();
			}
		}

		throw new NotFoundException("Utente non trovato");
	}

	// CERCA E CANCELLA UTENTE TRAMITE ID
	public void findByIdAndDelete(UUID id) throws NotFoundException {
		User found = this.findById(id);
		uR.delete(found);
	}

	public User findByEmail(String email) {
		return uR.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("Utente con email " + email + " non trovato"));
	}
}