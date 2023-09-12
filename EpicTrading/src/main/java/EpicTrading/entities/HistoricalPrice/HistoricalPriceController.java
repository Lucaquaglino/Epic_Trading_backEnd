package EpicTrading.entities.HistoricalPrice;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historicalPrice")
public class HistoricalPriceController {
	private final HistoricalPriceService historicalPriceService;

	@Autowired
	public HistoricalPriceController(HistoricalPriceService historicalPriceService) {
		this.historicalPriceService = historicalPriceService;
	}

	@GetMapping("/{marketDataId}")
	public ResponseEntity<List<HistoricalPrice>> getHistoricalPricesByMarketDataId(@PathVariable UUID marketDataId) {
		List<HistoricalPrice> historicalPrices = historicalPriceService
				.findHistoricalPricesByMarketDataId(marketDataId);

		if (historicalPrices.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(historicalPrices);
	}
}
