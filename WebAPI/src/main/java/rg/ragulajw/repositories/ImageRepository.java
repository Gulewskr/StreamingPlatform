package rg.ragulajw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rg.ragulajw.data.domain.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
