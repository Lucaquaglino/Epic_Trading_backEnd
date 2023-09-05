package EpicTrading.entities.order;

import java.time.LocalDate;
import java.util.UUID;

import EpicTrading.entities.MarketData.MarketData;
import EpicTrading.entities.transaction.Transaction;
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
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
	@Id
	@GeneratedValue
	private UUID id;
	private LocalDate timeStamp;
	private int quantity;
//	private double price;
	@Enumerated(EnumType.STRING)
	private OrderType OrderType;
	@OneToOne
	private MarketData marketData;
	@OneToOne
	private Transaction transaction;
}
