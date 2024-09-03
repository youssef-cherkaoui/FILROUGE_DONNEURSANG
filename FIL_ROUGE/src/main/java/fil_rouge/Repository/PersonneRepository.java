package fil_rouge.Repository;

import fil_rouge.Model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

    Optional<Personne> findByEmail(String email);


}
