package EpicTrading.entities.order;

import java.time.LocalDate;
import java.util.UUID;

import EpicTrading.entities.MarketData.MarketData;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders", indexes = {
		@Index(name = "uk_glmm3bvnot7joswv497j7ne64", columnList = "market_data_id", unique = false) })
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
	@JoinColumn(name = "market_data_id", unique = false)
	private MarketData marketData;

}
