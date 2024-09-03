package fil_rouge.Repository;

import fil_rouge.Model.CentreCollectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CentreCollectRepository extends JpaRepository<CentreCollectModel, Long> {

    List<CentreCollectModel> findByNomCentre(String nomCentre);


}
