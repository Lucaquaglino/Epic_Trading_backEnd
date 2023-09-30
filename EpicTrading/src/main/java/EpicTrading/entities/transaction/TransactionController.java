package EpicTrading.entities.transaction;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	TransactionService tS;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Transaction saveTransaction(@RequestBody NewTransactionWithOrderPayload body) {
		Transaction createdTransaction = tS.createTransaction(body);
		return createdTransaction;
	}

	@GetMapping("")
	public Page<Transaction> findAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "timeStamp") String order) {
		return tS.findAll(page, order);
	}

	@GetMapping("/{userId}")
	public Page<Transaction> findByUserId(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "id") String order, @PathVariable UUID userId) {
		return tS.findByUserId(page, order, userId);
	}

}