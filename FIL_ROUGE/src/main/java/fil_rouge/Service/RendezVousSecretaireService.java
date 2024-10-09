package fil_rouge.Service;

import fil_rouge.Model.RendezVousModel;

import java.util.List;

public interface RendezVousSecretaireService {

     List<RendezVousModel> getAllRDV();
     void confirmerRendezVous(Long idRdv);
     void annulerRendezVous(Long IdRdv);
}
