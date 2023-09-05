package EpicTrading.entities.MarketData;

import java.time.LocalDate;
import java.util.UUID;

import EpicTrading.entities.order.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MarketData")
@Data
@NoArgsConstructor
public class MarketData {
	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private String symbol;
	private double price;
	private double volume;
	private LocalDate timeStamp;
	@OneToOne
	private Order order;
}
