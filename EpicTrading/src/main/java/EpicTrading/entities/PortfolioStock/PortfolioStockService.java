package EpicTrading.entities.PortfolioStock;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import EpicTrading.exceptions.NotFoundException;

@Service
public class PortfolioStockService {

	@Autowired
	private PortfolioStockRepository pR;

//	public Page<PortfolioStock> findAll(int page, String sort) {
//		Pageable pageable = PageRequest.of(page, 20, Sort.by(sort));
//		return pR.findAll(pageable);
//	}

	public Page<PortfolioStock> findByUserId(int page, String sort, UUID userId) {
		Pageable pageable = PageRequest.of(page, 60, Sort.by(sort));
		return pR.findByUserId(userId, pageable);
	}

	public PortfolioStock findById(UUID id) throws NotFoundException {
		return pR.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

//	public PortfolioStock findByMarketDataIdAndUserId(UUID marketDataId, UUID userId) {
//		return pR.findByMarketDataIdAndIdUser(marketDataId, userId);
//	}

	public PortfolioStock findByMarketDataIdAndUserIdAndTimestamp(UUID marketDataId, UUID userId,
			LocalDateTime timestamp) {
		return pR.findByMarketDataIdAndIdUserAndTimestamp(marketDataId, userId, timestamp);
	}

}
