package EpicTrading.entities.MarketData;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

//	public List<MarketData>getAllMarketData()() {
//		return marketDataRepository.findAll();
//	}
	public Page<MarketData> getAllMarketData(int page, String sort) {
		Pageable pageable = PageRequest.of(page, 100, Sort.by(sort));
		return marketDataRepository.findAll(pageable);
	}
}

//	public Page<MarketData> findAll(int page, String sort) {
//		Pageable pageable = PageRequest.of(page, 10, Sort.by(sort));
//		return tR.findAll(pageable);
//	}
