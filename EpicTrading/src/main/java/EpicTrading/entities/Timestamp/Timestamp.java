package EpicTrading.entities.Timestamp;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Timestamp")
@Data
@NoArgsConstructor
public class Timestamp {
	@Id
	@GeneratedValue
	private UUID id;
	private LocalDateTime dateTime;
	private double price;
	private UUID historicalPriceId;

	public Timestamp(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}