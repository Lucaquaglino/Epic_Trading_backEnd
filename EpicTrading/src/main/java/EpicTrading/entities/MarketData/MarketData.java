package EpicTrading.entities.MarketData;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

}
