package EpicTrading.entities.MarketData;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketDataService {

	@Autowired
	private MarketDataRepository marketDataRepository;

//	@Scheduled(fixedRate = 10000) // Esegui ogni 10 secondi
	public void updateMarketDataPrices() {
		List<MarketData> marketDataList = marketDataRepository.findAll();
		Random random = new Random();

		for (MarketData data : marketDataList) {
			double currentPrice = data.getPrice();
			double percentageChange = (random.nextDouble() - 0.5) * 0.1; // Cambio percentuale casuale tra -5% e +5%
			double newPrice = currentPrice * (1 + percentageChange);

			data.setPrice(newPrice);
			marketDataRepository.save(data);
		}

		System.out.println("Parametro 'price' aggiornato per tutte le istanze di MarketData...");
	}

}
