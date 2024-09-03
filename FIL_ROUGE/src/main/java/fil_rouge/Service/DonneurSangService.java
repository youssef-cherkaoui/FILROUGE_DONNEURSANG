package fil_rouge.Service;

import fil_rouge.Enums.GroupSanguin;
import fil_rouge.Model.CentreCollectModel;
import fil_rouge.Model.DonneurSangModel;
import fil_rouge.Model.RendezVousModel;

import java.util.List;

public interface DonneurSangService {

    DonneurSangModel CreateDonneurSang(DonneurSangModel donneur);
    DonneurSangModel getDonneurSangById(Long id);
    List<DonneurSangModel> getAllDonneurSang();
    DonneurSangModel updateDonneurSang(Long id, DonneurSangModel donneurSangModel);
    void deleteDonneurSang(Long id);
    List<RendezVousModel> getHistoriqueRDV(Long idDonneur);
    List<DonneurSangModel> filterByGrpSanguin(GroupSanguin groupSanguin);
    RendezVousModel demanderRDV(Long IdDonneur, RendezVousModel RDV);
    List<CentreCollectModel> rechercherCentre(String nomCentre);
}
