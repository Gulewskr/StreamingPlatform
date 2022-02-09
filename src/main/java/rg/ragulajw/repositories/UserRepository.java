package rg.ragulajw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rg.ragulajw.data.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
