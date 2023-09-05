package EpicTrading.entities.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public List<Transaction> getTransactions() {
		return tS.getAllTransactions();
	}
}