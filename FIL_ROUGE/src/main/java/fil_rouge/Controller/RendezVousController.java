package fil_rouge.Controller;

import fil_rouge.Model.RendezVousModel;
import fil_rouge.Repository.RendezVousRepository;
import fil_rouge.Service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/RendezVous")
@CrossOrigin(origins = "*")
public class RendezVousController {


    @Autowired
    private RendezVousService rendezVousService;

    @Autowired
    private RendezVousRepository rendezVousReposirory;

    @PostMapping("/CreateRDV")
    public RendezVousModel CreateRendezVous(@RequestBody RendezVousModel rendezVousModel){
        return rendezVousService.CreateRendezVous(rendezVousModel);
    }

    @GetMapping("/ShowAllRDV")
    public List<RendezVousModel> getAllRDV(){
        return rendezVousService.getAllRDV();
    }

    @DeleteMapping("/{id}")
    public void deleteRDV(@PathVariable Long id){
        rendezVousService.deleteRDV(id);
    }

    @PutMapping("/editRDV/{id}")
    public RendezVousModel updateRDV(@PathVariable Long id, @RequestBody RendezVousModel Status){
        return rendezVousService.updateRDV(id, Status);
    }

}
