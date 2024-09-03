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
    public List<SecretaireModel> getAllSecretaire() {
        return secretaireRepository.findAll();
    }


    @Override
    public void deleteSecretaire(Long id){
        secretaireRepository.deleteById(id);
    }


}
