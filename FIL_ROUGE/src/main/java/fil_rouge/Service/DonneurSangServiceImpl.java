package fil_rouge.Service;

import fil_rouge.Enums.GroupSanguin;
import fil_rouge.Model.CentreCollectModel;
import fil_rouge.Model.DonneurSangModel;
import fil_rouge.Model.RendezVousModel;
import fil_rouge.Repository.CentreCollectRepository;
import fil_rouge.Repository.DonneurSangRepository;
import fil_rouge.Repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonneurSangServiceImpl implements DonneurSangService{

    @Autowired
    private DonneurSangRepository donneurSangRepository;

    @Autowired
    private RendezVousRepository rendezVousReposirory;

    @Autowired
    private CentreCollectRepository centreCollectRepository;


    @Override
    public DonneurSangModel CreateDonneurSang(DonneurSangModel donneur){
        return donneurSangRepository.save(donneur);
    }


    @Override
    public DonneurSangModel getDonneurSangById(Long id){
        return donneurSangRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Donneur de sang non trouvé"));
    }


    @Override
    public List<DonneurSangModel> getAllDonneurSang(){
        return donneurSangRepository.findAll();
    }

    @Override
    public DonneurSangModel updateDonneurSang(Long id, DonneurSangModel donneurSangModel){
        DonneurSangModel existingDonneurSang = donneurSangRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Donneur Non trouvé"));
        existingDonneurSang.setNom(donneurSangModel.getNom());
        existingDonneurSang.setEmail(donneurSangModel.getEmail());
        existingDonneurSang.setMotdepasse(donneurSangModel.getMotdepasse());
        existingDonneurSang.setTelephone(donneurSangModel.getTelephone());
        existingDonneurSang.setGroupSanguin(donneurSangModel.getGroupSanguin());

        return donneurSangRepository.save(existingDonneurSang);
    }

    @Override
    public void deleteDonneurSang(Long id) {
        donneurSangRepository.deleteById(id);
    }


    @Override
    public List<RendezVousModel> getHistoriqueRDV(Long idDonneur){
        DonneurSangModel donneurSang = getDonneurSangById(idDonneur);
        return donneurSang.getRendezVous();
    }


    @Override
    public List<DonneurSangModel> filterByGrpSanguin(GroupSanguin groupSanguin){
        return donneurSangRepository.findByGroupSanguin(groupSanguin);
    }


    @Override
    public RendezVousModel demanderRDV(Long IdDonneur, RendezVousModel RDV){
        DonneurSangModel doneurSang = getDonneurSangById(IdDonneur);
        RDV.setDonneurSang(doneurSang);
        return rendezVousReposirory.save(RDV);
    }


    @Override
    public List<CentreCollectModel> rechercherCentre(String nomCentre){
        return centreCollectRepository.findByNomCentre(nomCentre);
    }
}
