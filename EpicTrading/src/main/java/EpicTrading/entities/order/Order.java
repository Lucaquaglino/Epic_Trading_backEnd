package EpicTrading.entities.order;

import java.time.LocalDate;
import java.util.UUID;

import EpicTrading.entities.MarketData.MarketData;
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

	public Order(LocalDate timeStamp, int quantity, OrderType orderType, MarketData marketData) {
		super();

		this.timeStamp = timeStamp;
		this.quantity = quantity;
		OrderType = orderType;
		this.marketData = marketData;

	}

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

}
