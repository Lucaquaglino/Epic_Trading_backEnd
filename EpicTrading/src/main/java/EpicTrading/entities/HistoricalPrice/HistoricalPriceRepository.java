package EpicTrading.entities.HistoricalPrice;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricalPriceRepository extends JpaRepository<HistoricalPrice, UUID> {

	List<HistoricalPrice> findByIdMarketData(UUID idMarketData);
}