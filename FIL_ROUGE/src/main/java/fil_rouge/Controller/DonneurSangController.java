package fil_rouge.Controller;

import fil_rouge.Enums.GroupSanguin;
import fil_rouge.Model.CentreCollectModel;
import fil_rouge.Model.DonneurSangModel;
import fil_rouge.Model.RendezVousModel;
import fil_rouge.Service.DonneurSangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/Admin")
@CrossOrigin(origins = "*")
public class DonneurSangController {

    @Autowired
    private DonneurSangService donneurSangService;

    @PostMapping("/CreateDonneur")
    public DonneurSangModel createDonneurSang(@RequestBody DonneurSangModel donneurSangModel){
        return donneurSangService.CreateDonneurSang(donneurSangModel);
    }

    @GetMapping("/ShowDonneurByID/{id}")
    public DonneurSangModel getDonneurById(@PathVariable Long id){
        return donneurSangService.getDonneurSangById(id);
    }

    @GetMapping("/ShowAllDonneur")
    public List<DonneurSangModel> getAllDonneur(){
        return donneurSangService.getAllDonneurSang();
    }

    @PutMapping("/editDonneur/{id}")
    public  DonneurSangModel updateDonneur(@PathVariable Long id,@RequestBody DonneurSangModel donneurSangModel){
        return donneurSangService.updateDonneurSang(id, donneurSangModel);
    }

    @DeleteMapping("/deleteDonneur/{id}")
    public void deleteDonneur(@PathVariable Long id){
        donneurSangService.deleteDonneurSang(id);
    }

    @GetMapping("/historique/{id}")
    public List<RendezVousModel> getHistoriqueRDV(@PathVariable Long id){
        return donneurSangService.getHistoriqueRDV(id);
    }

    @GetMapping("/filtre")
    public List<DonneurSangModel> filtreGrpSanguin(@RequestParam GroupSanguin groupSanguin){
        return donneurSangService.filterByGrpSanguin(groupSanguin);
    }

    @PostMapping("/demanderRDV/{id}")
    public RendezVousModel demanderRDV(@PathVariable Long id, @RequestBody RendezVousModel RDV){
        return donneurSangService.demanderRDV(id,RDV);
    }

    @GetMapping("/rechercheCentre")
    public List<CentreCollectModel> rechercherCentre(@RequestParam String nomCentre){
        return donneurSangService.rechercherCentre(nomCentre);
    }
}
