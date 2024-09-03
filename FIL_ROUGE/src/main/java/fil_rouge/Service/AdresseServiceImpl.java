package fil_rouge.Service;

import fil_rouge.Enums.Region;
import fil_rouge.Enums.Ville;
import fil_rouge.Model.AdresseModel;
import fil_rouge.Repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseServiceImpl implements AdresseService{

    @Autowired
    private AdresseRepository adresseRepository;


    @Override
    public AdresseModel CreateAdresse(AdresseModel adress){
        return adresseRepository.save(adress);
    }


    @Override
    public AdresseModel GetAdresseById(Long id){
        return adresseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adresse non trouvée"));
    }


    @Override
    public List<AdresseModel> getAllAdresses(){
        return adresseRepository.findAll();
    }


    @Override
    public AdresseModel updateAdresse(Long id , AdresseModel adresse){
        AdresseModel existingAdresse = adresseRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("adresse non trouvée"));

        existingAdresse.setRue(adresse.getRue());
        existingAdresse.setVille(adresse.getVille());
        existingAdresse.setRegion(adresse.getRegion());
        existingAdresse.setCodePostal(adresse.getCodePostal());

        return adresseRepository.save(existingAdresse);
    }


    @Override
    public void deleteAdresse(Long id){
        adresseRepository.deleteById(id);
    }


    @Override
    public List<AdresseModel> findAdresseByRegion(Region region){
        return adresseRepository.findByRegion(region);
    }

    @Override
    public List<AdresseModel> findAdresseByVille(Ville ville){
        return adresseRepository.findByVille(ville);
    }


    @Override
    public List<AdresseModel> findAdresseByCodePostal(String codePostal){
        return adresseRepository.findByCodePostal(codePostal);
    }


}
