package EpicTrading;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import EpicTrading.entities.MarketData.MarketData;
import EpicTrading.entities.MarketData.MarketDataRepository;

@Component
public class MarketDataRunner implements CommandLineRunner {

	@Autowired
	private MarketDataRepository marketDataRepository;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker();
		List<MarketData> marketDataDb = marketDataRepository.findAll();
//		if (marketDataDb.isEmpty()) {
		for (int i = 0; i < 200; i++) {
			MarketData marketData = new MarketData();
			marketData.setName(faker.company().name());
			marketData.setSymbol(faker.stock().nsdqSymbol());
			marketData.setPrice(faker.number().randomDouble(2, 10, 1000)); // Prezzo casuale tra 10 e 1000 con 2
																			// decimali
			marketData.setVolume(faker.number().randomDouble(2, 100, 10000)); // Volume casuale tra 100 e 10000 con
																				// 2
																				// decimali
			marketData.setTimeStamp(LocalDate.now().minusDays(i)); // Data attuale meno i giorni

			marketDataRepository.save(marketData);
		}
	}
}
//}