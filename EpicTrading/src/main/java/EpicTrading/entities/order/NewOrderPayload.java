package EpicTrading.entities.order;

import java.time.LocalDate;

import EpicTrading.entities.MarketData.MarketData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewOrderPayload {

	private LocalDate timeStamp;
	private int quantity;
	private OrderType orderType;
	private MarketData marketData;

}
