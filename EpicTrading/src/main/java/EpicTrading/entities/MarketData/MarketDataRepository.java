package EpicTrading.entities.MarketData;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketDataRepository extends JpaRepository<MarketData, UUID> {
//	List<MarketData> findAll(); //

	Optional<MarketData> findByName(String name);
}
