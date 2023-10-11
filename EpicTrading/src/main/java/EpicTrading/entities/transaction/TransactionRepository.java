package EpicTrading.entities.transaction;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
//	@Query("SELECT tS FROM Transactions ps WHERE ps.idUser = :userId")
	Page<Transaction> findByUserId(@Param("userId") UUID userId, Pageable pageable);
}
