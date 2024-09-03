package fil_rouge.Service;

import fil_rouge.Model.AdresseModel;
import fil_rouge.Model.CentreCollectModel;
import fil_rouge.Repository.AdresseRepository;
import fil_rouge.Repository.CentreCollectRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentreCollectServiceImpl implements CentreCollectService{

    @Autowired
    CentreCollectRepository centreCollectRepository;

    @Autowired
    AdresseRepository adresseRepository;

    @Autowired
    private EntityManager entityManager;


//    @Override
//    public CentreCollectModel AddCentreCollect(CentreCollectModel centreCollectModel) {
//
//        CentreCollectModel AddCentre = centreCollectRepository.save(centreCollectModel);
//        return AddCentre;
//    }

    @Override
    @Transactional
    public CentreCollectModel AddCentreCollect(CentreCollectModel centreCollectModel) {
        if(centreCollectModel.getAdresse() !=null){
            centreCollectModel.setAdresse(entityManager.merge(centreCollectModel.getAdresse()));
        }
        return centreCollectRepository.save(centreCollectModel);
    }


    @Override
    public List<CentreCollectModel> getAllCentreCollect() {
        return centreCollectRepository.findAll();
    }

    @Override
    public List<CentreCollectModel> findByNomCentre(String nomCentre){
        return centreCollectRepository.findByNomCentre(nomCentre);
    }


    @Override
    public CentreCollectModel updateCentre(Long id, CentreCollectModel centreCollectModel) {
        CentreCollectModel centre = centreCollectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centre not found"));
        centre.setNomCentre(centreCollectModel.getNomCentre());
        CentreCollectModel updateCentre = centreCollectRepository.save(centre);
        return updateCentre;
    }


    @Override
    public CentreCollectModel getCentreById(Long id) {
        return centreCollectRepository.findById(id).orElseThrow(() -> new RuntimeException("Centre not found"));
    }


    @Override
    public void deleteCentreCollecte(Long id) {
        centreCollectRepository.deleteById(id);
    }


    //Assigne une adresse a un centre
    @Override
    public CentreCollectModel AssignAdresseToCentre(Long id, AdresseModel adresseModel){

        CentreCollectModel centreCollect = getCentreById(id);
        adresseRepository.save(adresseModel);
        centreCollect.setAdresse(adresseModel);
        return centreCollectRepository.save(centreCollect);
    }

    //obtenir adresse associé a un centre
    @Override
    public AdresseModel getAdressByCentre(Long id){
        CentreCollectModel centreCollect = getCentreById(id);
        return  centreCollect.getAdresse();
    }
}
