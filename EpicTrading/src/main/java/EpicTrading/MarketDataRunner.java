//package EpicTrading;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Locale;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.github.javafaker.Faker;
//
//import EpicTrading.entities.HistoricalPrice.HistoricalPrice;
//import EpicTrading.entities.HistoricalPrice.HistoricalPriceRepository;
//import EpicTrading.entities.MarketData.MarketData;
//import EpicTrading.entities.MarketData.MarketDataRepository;
//import EpicTrading.entities.Timestamp.Timestamp;
//import EpicTrading.entities.Timestamp.TimestampRepository;
//
//@Component
//public class MarketDataRunner implements CommandLineRunner {
//
//	@Autowired
//	private MarketDataRepository marketDataRepository;
//
//	@Autowired
//	private HistoricalPriceRepository hPR;
//	@Autowired
//	private TimestampRepository tR;
//
//	@Override
//	public void run(String... args) throws Exception {
//		Faker faker = new Faker(new Locale("en-US")); // Imposta la locale su "en-US"
//		List<MarketData> marketDataDb = marketDataRepository.findAll();
////		if (marketDataDb.isEmpty()) {
//		for (int i = 0; i < 50; i++) {
//			MarketData marketData = new MarketData();
//			marketData.setName(faker.company().name());
//			marketData.setSymbol(faker.stock().nsdqSymbol());
//
////			// Converti il prezzo in una stringa con il punto come separatore decimale
////			String priceString = String.format(Locale.US, "%.2f", faker.number().randomDouble(2, 10, 1000));
////			marketData.setPrice(Double.parseDouble(priceString)); // Converte nuovamente in double
//
//			marketData.setVolume(faker.number().randomDouble(2, 100, 10000)); // Volume casuale tra 100 e 10000 con 2
//																				// decimali
////			marketData.setTimeStamp(LocalDate.now().minusDays(i)); // Data attuale meno i giorni
//
//			marketDataRepository.save(marketData);
//			for (int f = 0; f < 30; f++) {
//				HistoricalPrice historicalPrice = new HistoricalPrice();
//				historicalPrice.setDateTime(LocalDateTime.now().minusDays(f));
//				historicalPrice.setIdMarketData(marketData.getId());
//
//				hPR.save(historicalPrice);
//				marketData.getHistoricalPrices().add(historicalPrice);
//				LocalDateTime historicalPriceDateTime = historicalPrice.getDateTime();
//				for (int w = 0; w < 24; w++) {
//					Timestamp timestamp = new Timestamp();
//					LocalDateTime timestampDateTime = historicalPriceDateTime.withHour(w); // Imposta l'ora nel loop
//					timestamp.setDateTime(timestampDateTime);
//					timestamp.setHistoricalPriceId(historicalPrice.getId());
//
//					// Converti il prezzo in una stringa con il punto come separatore decimale
//					String priceStringTimestamp = String.format(Locale.US, "%.2f",
//							faker.number().randomDouble(2, 10, 1000));
//					timestamp.setPrice(Double.parseDouble(priceStringTimestamp)); // Converte nuovamente in double
//
//					tR.save(timestamp);
//					historicalPrice.getTimestamp().add(timestamp);
//					double averagePrice = timestamp.getPrice();
//					historicalPrice.setPrice(averagePrice);
//
//					// Ora puoi salvare il tuo oggetto Timestamp o fare altre operazioni necessarie
//				}
//
//				hPR.save(historicalPrice);
//				marketData.setPrice(historicalPrice.getPrice());
//			}
//
//			marketDataRepository.save(marketData);
//		}
//	}
//
//
////	}
////
//
//}
