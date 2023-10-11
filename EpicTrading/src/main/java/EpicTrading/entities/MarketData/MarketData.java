package EpicTrading.entities.MarketData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import EpicTrading.entities.HistoricalPrice.HistoricalPrice;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "MarketData")
@Data
@AllArgsConstructor
public class MarketData {
	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private String symbol;
	private double price;
	private double volume;
	private LocalDate timeStamp;

	@OneToMany
	private List<HistoricalPrice> historicalPrices;

	public MarketData() {
		this.historicalPrices = new ArrayList<>();
	}
}
