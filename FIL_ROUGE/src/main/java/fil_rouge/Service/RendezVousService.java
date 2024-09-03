package fil_rouge.Service;

import fil_rouge.Model.RendezVousModel;

import java.util.List;

public interface RendezVousService {

    public RendezVousModel CreateRendezVous(RendezVousModel rendezvousmodel);
    List<RendezVousModel> getAllRDV();
    void deleteRDV(Long id);
    RendezVousModel updateRDV(Long id , RendezVousModel Status);
}
