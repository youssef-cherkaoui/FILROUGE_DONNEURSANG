package fil_rouge.Controller;

import fil_rouge.Enums.Region;
import fil_rouge.Enums.Ville;
import fil_rouge.Model.AdresseModel;
import fil_rouge.Service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AdresseController {

    @Autowired
    private AdresseService adressService;

    @PostMapping("/CreateAdresse")
    public AdresseModel CreateAdresse(@RequestBody AdresseModel adress){
        return adressService.CreateAdresse(adress);
    }


    @GetMapping("ShowAllAdress")
    public List<AdresseModel> getAllAdresse(){
        return adressService.getAllAdresses();
    }

    @GetMapping("/adresse/{id}")
    public AdresseModel GetAdresseById(@PathVariable Long id){
        return adressService.GetAdresseById(id);
    }

    @PutMapping("/editAdresse/{id}")
    public AdresseModel updateAdresse(@PathVariable Long id, @RequestBody AdresseModel adress){
        return adressService.updateAdresse(id, adress);
    }

    @DeleteMapping("/{id}")
    public void  deleteAdresse(@PathVariable Long id){
        adressService.deleteAdresse(id);
    }

    @GetMapping("/region/{region}")
    public List<AdresseModel> findAdressByRegion(@PathVariable Region region){
        return adressService.findAdresseByRegion(region);
    }

    @GetMapping("/ville/{ville}")
    public List<AdresseModel> findAdressByVille(@PathVariable Ville ville){
        return adressService.findAdresseByVille(ville);
    }

    @GetMapping("/codePostal/{codePostal}")
    public List<AdresseModel> findAdressByCodePostal(@PathVariable String codePostal){
        return adressService.findAdresseByCodePostal(codePostal);
    }




}
