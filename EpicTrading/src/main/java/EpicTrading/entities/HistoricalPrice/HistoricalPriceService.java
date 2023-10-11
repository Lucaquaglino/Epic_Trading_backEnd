package EpicTrading.entities.HistoricalPrice;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricalPriceService {
	private final HistoricalPriceRepository historicalPriceRepository;

	@Autowired
	public HistoricalPriceService(HistoricalPriceRepository historicalPriceRepository) {
		this.historicalPriceRepository = historicalPriceRepository;
	}

	public List<HistoricalPrice> findHistoricalPricesByMarketDataId(UUID marketDataId) {
		return historicalPriceRepository.findByIdMarketData(marketDataId);
	}
}
