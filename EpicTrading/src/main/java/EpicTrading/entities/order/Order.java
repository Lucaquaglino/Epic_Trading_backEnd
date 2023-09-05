package EpicTrading.entities.order;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	private double price;
	@Enumerated(EnumType.STRING)
	private OrderType OrderType;
}
