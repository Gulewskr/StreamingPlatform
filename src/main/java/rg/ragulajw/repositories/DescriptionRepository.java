package rg.ragulajw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rg.ragulajw.data.domain.Description;
import rg.ragulajw.data.domain.User;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {
    Description findByUser_Id(long userId);
}
