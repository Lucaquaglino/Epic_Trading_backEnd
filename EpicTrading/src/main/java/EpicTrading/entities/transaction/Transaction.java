package EpicTrading.entities.transaction;

import java.time.LocalDate;
import java.util.UUID;

import EpicTrading.entities.MarketData.MarketData;
import EpicTrading.entities.order.Order;
import EpicTrading.entities.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue
	private UUID id;
	private LocalDate timeStamp;
	private double amount;
	private String currency;
	@Enumerated(EnumType.STRING)
	private TransactionType TransactionType;
	private UUID userId;
//	@ManyToOne
//	@JoinColumn(name = "userId")
//	private User user;

	@OneToOne
	private Order order;

	@OneToOne
	private MarketData marketData;

	public Transaction(LocalDate timeStamp, double amount, String currency, TransactionType transactionType,
			Order order, User user, UUID userId) {

		this.timeStamp = timeStamp;
		this.amount = amount;
		this.currency = currency;
		this.TransactionType = transactionType;
		this.order = order;
//		this.user = user;
		this.userId = userId;
	}
}
