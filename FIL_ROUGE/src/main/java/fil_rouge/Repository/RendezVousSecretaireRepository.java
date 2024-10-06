package fil_rouge.Repository;

import fil_rouge.Model.RendezVousModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousSecretaireRepository extends JpaRepository<RendezVousModel,Long> {
}
