package EpicTrading.entities.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EpicTrading.entities.MarketData.MarketData;
import EpicTrading.entities.MarketData.MarketDataRepository;
import EpicTrading.entities.order.Order;
import EpicTrading.entities.order.OrderRepository;
import EpicTrading.entities.user.UserRepository;
import EpicTrading.entities.user.UserService;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository tR;

	@Autowired
	private UserService uS;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MarketDataRepository marketDataRepository;
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

//	public Transaction createTransactionWithUser(NewTransactionPayload body) {
//		Transaction newTransaction = new Transaction(body.getTimeStamp(), body.getAmount(), body.getCurrency(),
//				body.getTransactionType(), null);
//
//		// Se hai l'ID dell'utente nel payload, puoi impostarlo direttamente sulla
//		// transazione
//		if (body.getUserId() != null) {
//			User user = uS.findById(body.getUserId());
//			newTransaction.setUser(user);
//		}
//
//		// Salva la transazione
//		return tR.save(newTransaction);
//	}

//	public Transaction createTransaction(NewTransactionWithOrderPayload body) {
//		Transaction newTransaction;
//
//		if (body.getTransactionType() == TransactionType.DEPOSIT
//				|| body.getTransactionType() == TransactionType.WITHDRAW) {
//			// Se il tipo di transazione è DEPOSIT o WITHDRAW, l'oggetto Order è null
//			newTransaction = new Transaction(body.getTimeStamp(), body.getAmount(), body.getCurrency(),
//					body.getTransactionType(), null);
//		} else {
//			// Altrimenti, crea una transazione con l'oggetto Order
//			newTransaction = new Transaction(body.getTimeStamp(), body.getAmount(), body.getCurrency(),
//					body.getTransactionType(), body.getOrder());
//		}
//
//		// Se hai l'ID dell'utente nel payload, puoi impostarlo direttamente sulla
//		// transazione
//		if (body.getUserId() != null) {
//			User user = uS.findById(body.getUserId());
//			newTransaction.setUser(user);
//		}
//
//		// Salva la transazione
//		return tR.save(newTransaction);
//	}

//	public Transaction createTransaction(NewTransactionWithOrderPayload body) {
//		Transaction newTransaction;
//
//		if (body.getTransactionType() == TransactionType.DEPOSIT
//				|| body.getTransactionType() == TransactionType.WITHDRAW) {
//			// Se il tipo di transazione è DEPOSIT o WITHDRAW, l'oggetto Order è null
//			newTransaction = new Transaction(body.getTimeStamp(), body.getAmount(), body.getCurrency(),
//					body.getTransactionType(), null);
//		} else {
//			// Crea un oggetto Order e salvalo nel database
//			Order newOrder = new Order();
//			newOrder.setTimeStamp(body.getTimeStamp());
//			newOrder.setQuantity(body.getOrder().getQuantity());
//			newOrder.setOrderType(body.getOrder().getOrderType());
//			newOrder.setMarketData(body.getOrder().getMarketData());
//
//			// Salva l'ordine nel database
//			orderRepository.save(newOrder);
//
//			// Crea una transazione con l'oggetto Order appena creato
//			newTransaction = new Transaction(body.getTimeStamp(), body.getAmount(), body.getCurrency(),
//					body.getTransactionType(), newOrder);
//		}
//
//		// Se hai l'ID dell'utente nel payload, puoi impostarlo direttamente sulla
//		// transazione
//		if (body.getUserId() != null) {
//			User user = uS.findById(body.getUserId());
//			newTransaction.setUser(user);
//		}
//
//		// Salva la transazione
//		return tR.save(newTransaction);
//	}
//
//	public Order getOrderById(UUID id) throws NotFoundException {
//		return tR.findById(id).orElseThrow(() -> new NotFoundException(id));
//	}

	public Transaction createTransaction(NewTransactionWithOrderPayload body) {
		// Creazione dell'oggetto MarketData (potresti ottenere questi dati da qualche
		// altra parte)
		MarketData marketData = new MarketData();
		marketData.setPrice(body.getOrder().getMarketData().getPrice());
//		marketData.setPrice(body.getOrder().getMarketData().getPrice());
		// Salva l'oggetto MarketData nel repository
		marketData = marketDataRepository.save(marketData);

		// Creazione dell'oggetto Order
		Order order = new Order();
		order.setMarketData(marketData); // Collega l'oggetto MarketData all'ordine
		order.setOrderType(body.getOrder().getOrderType());
		// Altre operazioni relative all'ordine, se necessario

		// Salva l'ordine nel repository
		order = orderRepository.save(order);

		// Creazione dell'oggetto Transaction
		Transaction newTransaction = new Transaction();
		newTransaction.setTimeStamp(body.getTimeStamp());
		newTransaction.setAmount(body.getAmount());
		newTransaction.setCurrency(body.getCurrency());
		newTransaction.setTransactionType(body.getTransactionType());
		newTransaction.setOrder(order); // Collega l'oggetto Order alla transazione
		newTransaction.setUserId(uS.getCurrentUser().getId());
//		// Collega l'utente alla transazione
//		User user = uS.findById(body.getUserId());
//		if (user == null) {
//			// Gestisci il caso in cui l'utente non esiste nel database
//		} else {
//			// Collega l'utente alla transazione
//			newTransaction.setUser(user);
//			// Salva la transazione nel repository

//		}

		// Aggiornamento dati cliente
//		uS.findByIdAndUpdateTransactions(body.getUserId(), newTransaction);
		// Salva la transazione nel repository

		return tR.save(newTransaction);

	}

	public List<Transaction> getAllTransactions() {
		return tR.findAll();
	}

}
