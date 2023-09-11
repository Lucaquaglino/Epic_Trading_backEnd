package EpicTrading.entities.PortfolioStock;

import java.util.UUID;

import EpicTrading.entities.MarketData.MarketData;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "portfoliostock")
@Data
@NoArgsConstructor
public class PortfolioStock {
	@Id
	@GeneratedValue
	private UUID id;

	private UUID idUser;

	@ManyToOne
	@JoinColumn(name = "market_data_id")
	private MarketData marketData;

	private int quantity;

	private double purchasePrice;

}