package fil_rouge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class DonneurSangModel extends Personne {


    @OneToMany(mappedBy = "donneurSang")
    @JsonIgnore
    private List<RendezVousModel> rendezVous;

}
