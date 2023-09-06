package EpicTrading.entities.MarketData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class MarketDataService {

	@Autowired
	private MarketDataRepository marketDataRepository;

	@Scheduled(cron = "0/10 * * * *") // Specifica l'intervallo di 60 secondi
	public void updateMarketDataPrices() {

		List<MarketData> allMarketData = marketDataRepository.findAll();

		for (MarketData marketData : allMarketData) {
			double newPrice = 3;// Scrivi qui la logica per ottenere il nuovo prezzo
			marketData.setPrice(newPrice);
		}

		// Salva le modifiche nel repository
		marketDataRepository.saveAll(allMarketData);
	}

	// Altri metodi del servizio per gestire operazioni relative ai MarketData
	@Scheduled(cron = "0/10 * * * *") // Specifica l'intervallo di 60 secondi
	public void updateMarketDataPrice(MarketData marketData, double newPrice) {
		marketData.setPrice(newPrice);
		marketDataRepository.save(marketData); // Salva l'oggetto con il nuovo prezzo nel database
	}

}
