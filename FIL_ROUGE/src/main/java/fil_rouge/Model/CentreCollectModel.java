package fil_rouge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CentreCollectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomCentre;




    @OneToMany(mappedBy = "centreCollecte")
    @JsonIgnore
    private List<SecretaireModel> secretaires;

    @OneToMany(mappedBy = "centreCollecte")
    @JsonIgnore
    private List<RendezVousModel> rendezVous;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse_id")
    private AdresseModel adresse;
}
