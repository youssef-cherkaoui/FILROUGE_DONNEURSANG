package fil_rouge.Repository;

import fil_rouge.Model.RendezVousModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RendezVousRepository extends JpaRepository<RendezVousModel,Long> {
}
