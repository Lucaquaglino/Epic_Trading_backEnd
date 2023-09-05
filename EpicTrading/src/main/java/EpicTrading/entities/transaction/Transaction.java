package EpicTrading.entities.transaction;

import java.time.LocalDate;
import java.util.UUID;

import EpicTrading.entities.order.Order;
import EpicTrading.entities.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	private Order order;

	public Transaction(LocalDate timeStamp, double amount, String currency, TransactionType transactionType,
			Order order) {

		this.timeStamp = timeStamp;
		this.amount = amount;
		this.currency = currency;
		this.TransactionType = transactionType;
		this.order = order;
	}
}
