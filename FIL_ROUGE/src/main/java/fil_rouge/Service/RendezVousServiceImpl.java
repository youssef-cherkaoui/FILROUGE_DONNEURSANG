package fil_rouge.Service;

import fil_rouge.Model.RendezVousModel;

import fil_rouge.Repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousServiceImpl implements RendezVousService {

    @Autowired
    private RendezVousRepository rendezVousRepository;


    @Override
    public RendezVousModel CreateRendezVous(RendezVousModel rendezvousmodel) {
        RendezVousModel rendezVousModel = new RendezVousModel();
        rendezVousModel.setCentreCollecte(rendezvousmodel.getCentreCollecte());
        rendezVousModel.setDonneurSang(rendezvousmodel.getDonneurSang());
        rendezVousModel.setStatus(rendezvousmodel.getStatus());
        rendezVousModel.setDate(rendezvousmodel.getDate());
        return rendezVousRepository.save(rendezVousModel);
    }


    @Override
    public List<RendezVousModel> getAllRDV(){
        return rendezVousRepository.findAll();
    }

    @Override
    public void deleteRDV(Long id){
        rendezVousRepository.deleteById(id);
    }


    @Override
    public RendezVousModel updateRDV(Long id, RendezVousModel Status){
        RendezVousModel rdv = rendezVousRepository.findById(id).orElseThrow(() -> new RuntimeException("RendezVous non trouvé"));
        rdv.setStatus(Status.getStatus());
        rdv.setCentreCollecte(rdv.getCentreCollecte());
        rdv.setDonneurSang(rdv.getDonneurSang());
        rdv.setDate(rdv.getDate());

        RendezVousModel updatedRDV = rendezVousRepository.save(rdv);
        return updatedRDV;
    }






}
