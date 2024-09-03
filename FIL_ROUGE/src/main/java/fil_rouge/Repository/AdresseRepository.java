package fil_rouge.Repository;

import fil_rouge.Enums.Region;
import fil_rouge.Enums.Ville;
import fil_rouge.Model.AdresseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdresseRepository extends JpaRepository<AdresseModel,Long> {

    List<AdresseModel> findByRegion(Region region);
    List<AdresseModel> findByVille(Ville ville);
    List<AdresseModel> findByCodePostal(String codePostal);


}
