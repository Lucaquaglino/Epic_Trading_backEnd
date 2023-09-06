package EpicTrading.entities.transaction;

import java.time.LocalDate;
import java.util.UUID;

import EpicTrading.entities.order.NewOrderPayload;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewTransactionPayload {

	private LocalDate timeStamp;
	private double amount;
	private String currency;

	private TransactionType TransactionType;
	private NewOrderPayload order;
	private UUID userId;
}
