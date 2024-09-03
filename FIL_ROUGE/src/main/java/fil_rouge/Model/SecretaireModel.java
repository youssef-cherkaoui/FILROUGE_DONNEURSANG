package fil_rouge.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("SECRETAIRE")
public class SecretaireModel extends Personne{


    @ManyToOne
    @JoinColumn(name = "centre_collecte_id")
    private CentreCollectModel centreCollecte;

}
