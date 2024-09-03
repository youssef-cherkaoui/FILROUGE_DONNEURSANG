package fil_rouge.Controller;

import fil_rouge.Model.SecretaireModel;
import fil_rouge.Service.SecretaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/Admin")
@CrossOrigin(origins = "*")
public class SecretaireController {

    @Autowired
    private SecretaireService secretaireService;

    @PostMapping("/AjoutSecretaire")
    public SecretaireModel AjouterSecretaire(@RequestBody SecretaireModel secretaire) {
        return secretaireService.AjouterSecretaire(secretaire);
    }

    @GetMapping("/ShowAllSecre")
    public List<SecretaireModel> ShowAllSecretaire() {
        return secretaireService.getAllSecretaire();
    }

    @DeleteMapping("/delete/{idSe}")
    public void DeleteSecretaire(@PathVariable Long idSe) {
        secretaireService.deleteSecretaire(idSe);
    }

}
