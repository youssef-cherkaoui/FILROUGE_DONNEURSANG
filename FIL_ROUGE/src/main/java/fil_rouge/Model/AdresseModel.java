package fil_rouge.Model;

import fil_rouge.Enums.Region;
import fil_rouge.Enums.Ville;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AdresseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Region region;
    private String codePostal;
    private String rue;
    @Enumerated(EnumType.STRING)
    private Ville ville;


}
