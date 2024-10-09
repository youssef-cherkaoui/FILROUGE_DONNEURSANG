package fil_rouge.Service;


import fil_rouge.Enums.Status;
import fil_rouge.Model.RendezVousModel;
import fil_rouge.Repository.RendezVousRepository;
import fil_rouge.Repository.RendezVousSecretaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousSecretaireServiceImpl implements RendezVousSecretaireService{

    @Autowired
    private RendezVousRepository rendezVousRepository;

    @Override
    public List<RendezVousModel> getAllRDV() {
        return rendezVousRepository.findAll();
    }


    @Override
    public void confirmerRendezVous(Long idRdv){
        RendezVousModel rdv = rendezVousRepository.findById(idRdv)
                .orElseThrow();
        rdv.setStatus(Status.VERIFIER);
        rendezVousRepository.save(rdv);
    }

    @Override
    public void annulerRendezVous(Long IdRdv){
        rendezVousRepository.deleteById(IdRdv);
    }
}
