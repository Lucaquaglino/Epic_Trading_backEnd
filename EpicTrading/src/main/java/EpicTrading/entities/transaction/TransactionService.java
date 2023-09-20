package EpicTrading.entities.transaction;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import EpicTrading.entities.MarketData.MarketData;
import EpicTrading.entities.MarketData.MarketDataRepository;
import EpicTrading.entities.MarketData.MarketDataService;
import EpicTrading.entities.PortfolioStock.PortfolioStock;
import EpicTrading.entities.PortfolioStock.PortfolioStockRepository;
import EpicTrading.entities.PortfolioStock.PortfolioStockService;
import EpicTrading.entities.order.Order;
import EpicTrading.entities.order.OrderRepository;
import EpicTrading.entities.order.OrderType;
import EpicTrading.entities.user.User;
import EpicTrading.entities.user.UserRepository;
import EpicTrading.entities.user.UserService;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository tR;

	@Autowired
	private UserService uS;

	@Autowired
	private PortfolioStockRepository portfolioStockRepository;

	@Autowired
	private PortfolioStockService pS;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MarketDataService mS;

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

//	public Transaction createTransaction(NewTransactionWithOrderPayload body) {
//		// 1. Crea e salva l'oggetto MarketData
//		MarketData marketData = new MarketData();
//		marketData.setPrice(body.getOrder().getMarketData().getPrice());
//		marketData = marketDataRepository.save(marketData);
//
//		// 2. Crea e salva l'oggetto Order
//		Order order = new Order();
//		order.setMarketData(marketData);
//		order.setOrderType(body.getOrder().getOrderType());
//		order = orderRepository.save(order);
//
//		// 3. Crea e salva l'oggetto Transaction
//		Transaction newTransaction = new Transaction();
//		newTransaction.setTimeStamp(body.getTimeStamp());
//		newTransaction.setAmount(body.getAmount());
//		newTransaction.setCurrency(body.getCurrency());
//		newTransaction.setTransactionType(body.getTransactionType());
//		newTransaction.setOrder(order);
//		newTransaction.setUserId(uS.getCurrentUser().getId());
//
//		// Salva la Transaction nel repository
//		newTransaction = tR.save(newTransaction);
//
//		// Aggiungi la nuova Transaction all'array delle transazioni dell'utente
//		User currentUser = uS.getCurrentUser();
//		currentUser.getTransaction().add(newTransaction);
//
//		handleTransactionAndBalance(newTransaction, currentUser);
//
//		// Salva l'utente aggiornato nel repository
//		userRepository.save(currentUser);
//
//		return newTransaction;
//	}

//	public Transaction createTransaction(NewTransactionWithOrderPayload body) {
//		// 1. Crea e salva l'oggetto Transaction
//		Transaction newTransaction = new Transaction();
//		newTransaction.setTimeStamp(body.getTimeStamp());
//		newTransaction.setAmount(body.getAmount());
//		newTransaction.setCurrency(body.getCurrency());
//		newTransaction.setTransactionType(body.getTransactionType());
//		newTransaction.setUserId(uS.getCurrentUser().getId());
//
//		if (body.getTransactionType() != TransactionType.DEPOSIT
//				&& body.getTransactionType() != TransactionType.WITHDRAW) {
//			// Se il tipo di transazione non è DEPOSIT o WITHDRAW, crea e collega l'oggetto
//			// MarketData e Order
//			MarketData marketData = new MarketData();
//			marketData.setPrice(body.getOrder().getMarketData().getPrice());
//			marketData = marketDataRepository.save(marketData);
//
//			Order order = new Order();
//			order.setMarketData(marketData);
//			order.setOrderType(body.getOrder().getOrderType());
//			order = orderRepository.save(order);
//
//			newTransaction.setOrder(order);
//		}
//
//		// Salva la Transaction nel repository
//		newTransaction = tR.save(newTransaction);
//
//		// Aggiungi la nuova Transaction all'array delle transazioni dell'utente
//		User currentUser = uS.getCurrentUser();
//		currentUser.getTransaction().add(newTransaction);
//
//		handleTransactionAndBalance(newTransaction, currentUser);
//
//		// Salva l'utente aggiornato nel repository
//		userRepository.save(currentUser);
//
//		return newTransaction;
//	}

//	public Transaction createTransaction(NewTransactionWithOrderPayload body) {
//		// 1. Crea e salva l'oggetto Transaction
//		Transaction newTransaction = new Transaction();
//		newTransaction.setTimeStamp(body.getTimeStamp());
//		newTransaction.setCurrency(body.getCurrency());
//		newTransaction.setTransactionType(body.getTransactionType());
//		newTransaction.setUserId(uS.getCurrentUser().getId());
//
//		// Verifica se il tipo di transazione richiede di calcolare l'importo
//		if (body.getTransactionType() != TransactionType.DEPOSIT
//				&& body.getTransactionType() != TransactionType.WITHDRAW) {
//			// 2. Crea e collega l'oggetto MarketData
//			MarketData marketData = new MarketData();
//			marketData.setPrice(body.getOrder().getMarketData().getPrice());
//			marketData = marketDataRepository.save(marketData);
//
////			UUID marketDataId = body.getOrder().getMarketData().getId();
////			MarketData marketData = marketDataRepository.findById(marketDataId).orElseThrow();
////			marketData.setPrice(body.getOrder().getMarketData().getPrice());
////			marketData = marketDataRepository.save(marketData);
//
//			// 3. Crea e collega l'oggetto Order
//			Order order = new Order();
//			order.setMarketData(marketData);
//			order.setOrderType(body.getOrder().getOrderType());
//			order.setQuantity(body.getOrder().getQuantity());
//			// Calcola l'importo
//			double amount = marketData.getPrice() * order.getQuantity();
//			newTransaction.setAmount(amount);
//
//			order = orderRepository.save(order);
//			newTransaction.setOrder(order);
//			// 4. Crea l'oggetto PortfolioStock
//			PortfolioStock portfolioStock = new PortfolioStock();
//			portfolioStock.setMarketData(marketData);
//			portfolioStock.setQuantity(body.getOrder().getQuantity());
//			portfolioStock.setPurchasePrice(marketData.getPrice());
//			portfolioStock.setIdUser(uS.getCurrentUser().getId()); // Assegna l'ID dell'utente all'oggetto
//																	// PortfolioStock
//
//			// Aggiungi l'oggetto PortfolioStock alla lista dell'utente
//			User currentUser = uS.getCurrentUser();
//			currentUser.getPortfolioStock().add(portfolioStock);
//
//			// 5. Salva il PortfolioStock nel repository
//			portfolioStock = portfolioStockRepository.save(portfolioStock);
//
//			// Aggiorna l'oggetto User nel repository
//			userRepository.save(currentUser);
//
//		} else {
//			// Se il tipo di transazione è DEPOSIT o WITHDRAW, usa l'importo fornito nel
//			// payload
//			newTransaction.setAmount(body.getAmount());
//		}
//
//		// Salva la Transaction nel repository
//		newTransaction = tR.save(newTransaction);
//
//		// Aggiungi la nuova Transaction all'array delle transazioni dell'utente
//		User currentUser = uS.getCurrentUser();
//		currentUser.getTransaction().add(newTransaction);
//
//		handleTransactionAndBalance(newTransaction, currentUser);
//
//		// Salva l'utente aggiornato nel repository
//		userRepository.save(currentUser);
//
//		return newTransaction;
//	}

	public Transaction createTransaction(NewTransactionWithOrderPayload body) {
		// 1. Crea e salva l'oggetto Transaction
		Transaction newTransaction = new Transaction();
		newTransaction.setTimeStamp(body.getTimeStamp());
		newTransaction.setCurrency(body.getCurrency());
		newTransaction.setTransactionType(body.getTransactionType());
		newTransaction.setUserId(uS.getCurrentUser().getId());

		// Verifica se il tipo di transazione richiede di calcolare l'importo
		if (body.getTransactionType() == TransactionType.BUY) {
			// 2. Crea e collega l'oggetto MarketData
			MarketData marketData = mS.findById(body.getMarketdata().getId());
			marketData.setPrice(marketData.getPrice());
			marketData.setSymbol(marketData.getSymbol());
			marketData.setVolume(marketData.getVolume());
			marketData.setName(marketData.getName());
			marketData = marketDataRepository.save(marketData);

//			UUID marketDataId = body.getOrder().getMarketData().getId();
//			MarketData marketData = marketDataRepository.findById(marketDataId).orElseThrow();
//			marketData.setPrice(body.getOrder().getMarketData().getPrice());
//			marketData = marketDataRepository.save(marketData);

			// 3. Crea e collega l'oggetto Order
			Order order = new Order();
			order.setMarketData(marketData);
			order.setOrderType(body.getOrder().getOrderType());
			order.setQuantity(body.getOrder().getQuantity());
			order.setTimeStamp(body.getOrder().getTimeStamp());
			// Calcola l'importo
			double amount = marketData.getPrice() * order.getQuantity();
			newTransaction.setAmount(amount);

			order = orderRepository.save(order);
			newTransaction.setOrder(order);
			// 4. Crea l'oggetto PortfolioStock

			PortfolioStock portfolioStock = new PortfolioStock();
			portfolioStock.setMarketData(marketData);
			portfolioStock.setQuantity(body.getOrder().getQuantity());
			portfolioStock.setPurchasePrice(marketData.getPrice());
			portfolioStock.setIdUser(uS.getCurrentUser().getId()); // Assegna l'ID dell'utente all'oggetto
																	// PortfolioStock

			// Aggiungi l'oggetto PortfolioStock alla lista dell'utente
			User currentUser = uS.getCurrentUser();
			currentUser.getPortfolioStock().add(portfolioStock);

			// 5. Salva il PortfolioStock nel repository
			portfolioStock = portfolioStockRepository.save(portfolioStock);

			// Aggiorna l'oggetto User nel repository
			userRepository.save(currentUser);

		} else if (body.getTransactionType() == TransactionType.DEPOSIT
				|| (body.getTransactionType() == TransactionType.WITHDRAW)) {
			// Se il tipo di transazione è DEPOSIT o WITHDRAW, usa l'importo fornito nel
			// payload
			newTransaction.setAmount(body.getAmount());

//			MarketData marketData = new MarketData();
//			marketData.setPrice(0);
//			marketData.setSymbol("");
//			marketData.setVolume(0);
//			marketData.setName("");
////			marketData = marketDataRepository.save(marketData);
			// 3. Crea e collega l'oggetto Order
			Order order = new Order();
			order.setMarketData(null);
			order.setOrderType(body.getOrder().getOrderType());
			order.setQuantity(body.getOrder().getQuantity());
			// Calcola l'importo
//						double amount = marketData.getPrice() * order.getQuantity();
//						newTransaction.setAmount(amount);

			order = orderRepository.save(order);
			newTransaction.setOrder(order);

			// prima delle aggiunte solo questo
			// Se il tipo di transazione è DEPOSIT o WITHDRAW, usa l'importo fornito nel
			// payload
			newTransaction.setAmount(body.getAmount());

//			// PER 2 RISPETTO A SOTTO TEST
//			// Salva la Transaction nel repository
//			newTransaction = tR.save(newTransaction);
//
//			// Aggiungi la nuova Transaction all'array delle transazioni dell'utente
//			User currentUser = uS.getCurrentUser();
//			currentUser.getTransaction().add(newTransaction);
//
//			handleTransactionAndBalance(newTransaction, currentUser);
//
//			// Salva l'utente aggiornato nel repository
//			userRepository.save(currentUser);
//
//			return newTransaction;
		} else if (body.getTransactionType() == TransactionType.SELL) {

//			UUID marketDataId = body.getMarketdata().getId();
//			PortfolioStock portfolioStockTimestamp = body
			// Cerca il PortfolioStock in base all'ID del MarketData

			PortfolioStock portfolioStock = pS.findById(body.getPortfolioStockId());
			MarketData marketData = mS.findById(body.getMarketdata().getId());
			// Recupera il prezzo dell'azione venduta
			double sellPrice = marketData.getPrice() * portfolioStock.getQuantity();
			// Recupera il prezzo di acquisto dell'azione nel PortfolioStock
			double purchasePrice = portfolioStock.getPurchasePrice();
			// Calcola il guadagno o la perdita dalla vendita
			double gainOrLoss = (sellPrice - purchasePrice) * portfolioStock.getQuantity();
			// ORDER???
			Order order = new Order();
			order.setMarketData(marketData);
			order.setOrderType(OrderType.SELL);
			order.setQuantity(portfolioStock.getQuantity());
			order.setTimeStamp(body.getOrder().getTimeStamp());
			order = orderRepository.save(order);
			newTransaction.setOrder(order);
			// Aggiungi il guadagno o la perdita al saldo dell'utente
			User currentUser = uS.getCurrentUser();
//			double currentBalance = currentUser.getBalance();
			double newBalance = gainOrLoss;
//			currentUser.setBalance(newBalance);

			newTransaction.setAmount(sellPrice);

			// Rimuovi il PortfolioStock dal portafoglio dell'utente
			currentUser.getPortfolioStock().remove(portfolioStock);

			// Salva le modifiche all'utente e rimuovi il PortfolioStock dal repository
			userRepository.save(currentUser);
			portfolioStockRepository.delete(portfolioStock);

		}

		// Salva la Transaction nel repository
		newTransaction = tR.save(newTransaction);

		// Aggiungi la nuova Transaction all'array delle transazioni dell'utente
		User currentUser = uS.getCurrentUser();
		currentUser.getTransaction().add(newTransaction);

		handleTransactionAndBalance(newTransaction, currentUser);

		// Salva l'utente aggiornato nel repository
		userRepository.save(currentUser);

		return newTransaction;
	}

// condizione per aumento o diminuzione balance user
	private void handleTransactionAndBalance(Transaction newTransaction, User currentUser) {
		if (newTransaction.getTransactionType() == TransactionType.BUY

				|| newTransaction.getTransactionType() == TransactionType.WITHDRAW) {
			double newBalance = currentUser.getBalance() - newTransaction.getAmount();

			// Verifica se il saldo diventerebbe negativo
			if (newBalance < 0) {
//	            throw new Exception("Saldo insufficiente per completare la transazione");
			}

			// Altrimenti, modifica il saldo dell'utente
			currentUser.setBalance(newBalance);
		} else if (newTransaction.getTransactionType() == TransactionType.DEPOSIT
				|| newTransaction.getTransactionType() == TransactionType.SELL) {
			// Se la transazione è di tipo DEPOSIT, aggiungi l'importo al saldo dell'utente
			double newBalance = currentUser.getBalance() + newTransaction.getAmount();
			currentUser.setBalance(newBalance);
		}
	}

	public Page<Transaction> findAll(int page, String sort) {
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sort));
		return tR.findAll(pageable);
	}

	public List<Transaction> getAllTransactions() {
		return tR.findAll();
	}

	public Page<Transaction> findByUserId(int page, String sort, UUID userId) {
		Pageable pageable = PageRequest.of(page, 60, Sort.by(sort));
		return tR.findByUserId(userId, pageable);
	}
}
