package fil_rouge.Controller;



import fil_rouge.Enums.Status;
import fil_rouge.Model.RendezVousModel;
import fil_rouge.Service.RendezVousSecretaireServiceImpl;
import fil_rouge.Service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth/SECRETAIRE")
@CrossOrigin(origins = "*")
public class RendezVsSecretaire {

    @Autowired
    private RendezVousService rendezVousService;
    @Autowired
    private RendezVousSecretaireServiceImpl rendezVousSecretaireServiceImpl;

    @GetMapping("/ShowAllRDV")
    public List<RendezVousModel> getAllRDV(){
        return rendezVousService.getAllRDV();
    }

    @PutMapping("/confirmer/{id}")
    public ResponseEntity<?> confirmerRendezVous(@PathVariable Long id){
        rendezVousSecretaireServiceImpl.confirmerRendezVous(id);
        return ResponseEntity.ok("RendezVous Confirmer");
    }

    @PutMapping("/annuler/{id}")
    public ResponseEntity<?> annulerRendezVous(@PathVariable Long id){
        rendezVousSecretaireServiceImpl.annulerRendezVous(id);
        return ResponseEntity.ok("RendezVous Annulé");
    }

//    @PutMapping("/{id}/status")
//    public ResponseEntity<?> updateRendezVousStatus(@PathVariable Long id, @RequestBody Map<String, String> request) {
//        try {
//            Status status = Status.valueOf(request.get("Status").toUpperCase());
//            boolean updated = rendezVousService.updateRDV(id,  status);
//            if (updated) {
//                return ResponseEntity.ok("Statut mis à jour avec succès");
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rendez-vous non trouvé");
//            }
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Statut invalide");
//        }
//    }

}
