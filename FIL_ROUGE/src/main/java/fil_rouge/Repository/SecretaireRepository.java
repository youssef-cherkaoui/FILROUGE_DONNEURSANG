package fil_rouge.Repository;

import fil_rouge.Model.SecretaireModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SecretaireRepository extends JpaRepository<SecretaireModel,Long> {
}
