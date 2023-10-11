package EpicTrading.entities.PortfolioStock;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioStockRepository extends JpaRepository<PortfolioStock, UUID> {
	@Query("SELECT ps FROM PortfolioStock ps WHERE ps.idUser = :userId")
	Page<PortfolioStock> findByUserId(@Param("userId") UUID userId, Pageable pageable);

	PortfolioStock findByMarketDataIdAndIdUserAndTimestamp(UUID marketDataId, UUID userId, LocalDateTime timestamp);
}
