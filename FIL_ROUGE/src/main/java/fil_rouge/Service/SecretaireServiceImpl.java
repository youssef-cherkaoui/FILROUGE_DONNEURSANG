package fil_rouge.Service;

import fil_rouge.Model.SecretaireModel;
import fil_rouge.Repository.SecretaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretaireServiceImpl implements SecretaireService{


    @Autowired
    private SecretaireRepository secretaireRepository;

    @Override
    public SecretaireModel AjouterSecretaire(SecretaireModel secretaire) {
        SecretaireModel ajoutSecretaire = secretaireRepository.save(secretaire);
        return ajoutSecretaire;

    }

    @Override
    public SecretaireModel getSecretaireById(Long id) {
        return secretaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Secretaire non trouvé"));
    }

    @Override
    public List<SecretaireModel> getAllSecretaire() {

        return secretaireRepository.findAll();
    }


    @Override
    public void deleteSecretaire(Long id){
        secretaireRepository.deleteById(id);
    }

    @Override
    public SecretaireModel updateSecretaire(Long id, SecretaireModel secretaireModel) {
        SecretaireModel existingSecretaire = secretaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Secretaire non trouvé"));

        // Mise à jour des champs
        existingSecretaire.setNom(secretaireModel.getNom());
        existingSecretaire.setEmail(secretaireModel.getEmail());
        existingSecretaire.setMotdepasse(secretaireModel.getMotdepasse());
        existingSecretaire.setTelephone(secretaireModel.getTelephone());
        existingSecretaire.setGroupSanguin(secretaireModel.getGroupSanguin());

        return secretaireRepository.save(existingSecretaire);
    }



}
