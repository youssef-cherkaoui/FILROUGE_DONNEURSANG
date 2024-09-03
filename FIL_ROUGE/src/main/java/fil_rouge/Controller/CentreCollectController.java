package fil_rouge.Controller;

import fil_rouge.Model.AdresseModel;
import fil_rouge.Model.CentreCollectModel;
import fil_rouge.Service.CentreCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/Admin/")
@CrossOrigin(origins = "*")
public class CentreCollectController {

    @Autowired
    private CentreCollectService centreCollectService;

    @PostMapping("/AddCentre")
    public CentreCollectModel AddCentreCollect(@RequestBody CentreCollectModel centreCollectModel) {
        return centreCollectService.AddCentreCollect(centreCollectModel);
    }

    @GetMapping("/ShowAllCentre")
    public List<CentreCollectModel> getAllCentreCollect() {
        return centreCollectService.getAllCentreCollect();
    }

    @GetMapping("/SearchCentre")
    public List<CentreCollectModel> findByNomCentre(@RequestParam String nomCentre) {
        return centreCollectService.findByNomCentre(nomCentre);
    }

    @PutMapping("/UpdateCentre/{id}")
    public CentreCollectModel updateCentre(@PathVariable Long id, @RequestBody CentreCollectModel centreCollectModel) {
        return centreCollectService.updateCentre(id,centreCollectModel);
    }

    //Endpoint pour assigner une adresse à un centre
    @PostMapping("/{CentreId}/adresse")
    public CentreCollectModel AssignAdresseToCentre(@PathVariable Long id, @RequestBody AdresseModel adress){
        return centreCollectService.AssignAdresseToCentre(id,adress);
    }


    @GetMapping("/{CentreId}/adresse")
    public AdresseModel getAdressByCentre(@PathVariable Long id){
        return centreCollectService.getAdressByCentre(id);
    }


}
