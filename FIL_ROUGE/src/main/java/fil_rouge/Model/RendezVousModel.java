package fil_rouge.Model;

import fil_rouge.Enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RendezVousModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "donneur_sang_id")
    private DonneurSangModel donneurSang;

    @ManyToOne
    @JoinColumn(name = "centre_collecte_id")
    private CentreCollectModel centreCollecte;
}
