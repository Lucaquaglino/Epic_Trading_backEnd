package EpicTrading.entities.PortfolioStock;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioStockRepository extends JpaRepository<PortfolioStock, UUID> {

}
