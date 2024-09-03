package fil_rouge.Service;

import fil_rouge.Enums.Region;
import fil_rouge.Enums.Ville;
import fil_rouge.Model.AdresseModel;

import java.util.List;

public interface AdresseService {

    AdresseModel CreateAdresse(AdresseModel adress);

    AdresseModel GetAdresseById(Long id);

    List<AdresseModel> getAllAdresses();

    AdresseModel updateAdresse(Long id, AdresseModel adresse);

    void deleteAdresse(Long id);

    List<AdresseModel> findAdresseByRegion(Region region);

    List<AdresseModel> findAdresseByVille(Ville ville);

    List<AdresseModel> findAdresseByCodePostal(String codePostal);

}
