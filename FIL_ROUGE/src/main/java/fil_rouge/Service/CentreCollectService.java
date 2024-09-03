package fil_rouge.Service;

import fil_rouge.Model.AdresseModel;
import fil_rouge.Model.CentreCollectModel;

import java.util.List;

public interface CentreCollectService {

    CentreCollectModel AddCentreCollect(CentreCollectModel centreCollectModel);

    List<CentreCollectModel> getAllCentreCollect();

    List<CentreCollectModel> findByNomCentre(String nomCentre);

    CentreCollectModel updateCentre(Long id, CentreCollectModel centreCollectModel);

    CentreCollectModel getCentreById(Long id);

    void deleteCentreCollecte(Long id);

    CentreCollectModel AssignAdresseToCentre(Long id, AdresseModel adresseModel);

    AdresseModel getAdressByCentre(Long id);
}
