package EpicTrading.entities.transaction;

import java.time.LocalDateTime;
import java.util.UUID;

import EpicTrading.entities.MarketData.MarketData;
import EpicTrading.entities.order.Order;
import EpicTrading.entities.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewTransactionWithOrderPayload {

	private LocalDateTime timeStamp;
	private double amount;
	private String currency;

	private TransactionType TransactionType;

	private Order order;
	private User user;
	private MarketData marketdata;
	private UUID marketDataId;
	private UUID portfolioStockId;
}
