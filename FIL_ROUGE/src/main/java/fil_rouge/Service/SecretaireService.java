package fil_rouge.Service;

import fil_rouge.Model.SecretaireModel;

import java.util.List;

public interface SecretaireService {

    SecretaireModel AjouterSecretaire(SecretaireModel secretaire);
    List<SecretaireModel> getAllSecretaire();
    void deleteSecretaire(Long id);

}
