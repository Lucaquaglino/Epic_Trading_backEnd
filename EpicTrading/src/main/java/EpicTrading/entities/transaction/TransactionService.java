package EpicTrading.entities.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EpicTrading.entities.user.User;
import EpicTrading.entities.user.UserService;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository tR;

	@Autowired
	private UserService uS;

//	public Transaction createTransaction(NewTransactionWithOrderPayload body) {
//		Transaction newTransaction = new Transaction(body.getTimeStamp(), body.getAmount(), body.getCurrency(),
//				body.getTransactionType(), body.getOrder());
//
//		Order order = body.getOrder();
//		newTransaction.setOrder(order);
//
//		// Se hai l'ID dell'utente nel payload, puoi impostarlo direttamente sulla
//		// transazione
//		if (body.getUserId() != null) {
//			User user = uS.findById(body.getUserId());
//			newTransaction.setUser(user);
//		}
//		if (order != null && order.getMarketData() != null) {
//			MarketData marketData = order.getMarketData();
//			order.setMarketData(marketData);
//		}
//		// Salva la transazione
//		return tR.save(newTransaction);
//	}

	public Transaction createTransactionWithUser(NewTransactionPayload body) {
		Transaction newTransaction = new Transaction(body.getTimeStamp(), body.getAmount(), body.getCurrency(),
				body.getTransactionType(), null);

		// Se hai l'ID dell'utente nel payload, puoi impostarlo direttamente sulla
		// transazione
		if (body.getUserId() != null) {
			User user = uS.findById(body.getUserId());
			newTransaction.setUser(user);
		}

		// Salva la transazione
		return tR.save(newTransaction);
	}

	public Transaction createTransaction(NewTransactionWithOrderPayload body) {
		Transaction newTransaction;

		if (body.getTransactionType() == TransactionType.DEPOSIT
				|| body.getTransactionType() == TransactionType.WITHDRAW) {
			// Se il tipo di transazione è DEPOSIT o WITHDRAW, l'oggetto Order è null
			newTransaction = new Transaction(body.getTimeStamp(), body.getAmount(), body.getCurrency(),
					body.getTransactionType(), null);
		} else {
			// Altrimenti, crea una transazione con l'oggetto Order
			newTransaction = new Transaction(body.getTimeStamp(), body.getAmount(), body.getCurrency(),
					body.getTransactionType(), body.getOrder());
		}

		// Se hai l'ID dell'utente nel payload, puoi impostarlo direttamente sulla
		// transazione
		if (body.getUserId() != null) {
			User user = uS.findById(body.getUserId());
			newTransaction.setUser(user);
		}

		// Salva la transazione
		return tR.save(newTransaction);
	}

//	public Order getOrderById(UUID id) throws NotFoundException {
//		return tR.findById(id).orElseThrow(() -> new NotFoundException(id));
//	}

	public List<Transaction> getAllTransactions() {
		return tR.findAll();
	}

}
