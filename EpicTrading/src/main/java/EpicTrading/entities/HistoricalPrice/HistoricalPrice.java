package EpicTrading.entities.HistoricalPrice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import EpicTrading.entities.Timestamp.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "HistoricalPrice")
@Data

@AllArgsConstructor

public class HistoricalPrice {
	@Id
	@GeneratedValue
	private UUID id;
	private LocalDateTime dateTime;
	private double price;

	private UUID idMarketData;

	@OneToMany
	private List<Timestamp> timestamp;

	public HistoricalPrice(LocalDateTime dateTime, double price) {
		this.dateTime = dateTime;
		this.price = price;
	}

	public HistoricalPrice() {
		this.timestamp = new ArrayList<>();
	}

}
