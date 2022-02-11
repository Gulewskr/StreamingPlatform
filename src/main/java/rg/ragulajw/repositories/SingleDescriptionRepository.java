package rg.ragulajw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rg.ragulajw.data.domain.SingleDescription;

@Repository
public interface SingleDescriptionRepository extends JpaRepository<SingleDescription, Long> {
}
