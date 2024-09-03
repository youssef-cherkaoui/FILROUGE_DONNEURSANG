package fil_rouge.Controller;

import fil_rouge.DTO.AuthenticationRequest;
import fil_rouge.DTO.AuthenticationResponse;
import fil_rouge.DTO.RegisterRequest;
import fil_rouge.Model.DonneurSangModel;
import fil_rouge.Model.SecretaireModel;
import fil_rouge.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private final AuthenticationService authenticationService;

    @PostMapping("/Admin/registerDonneur")
    public ResponseEntity<AuthenticationResponse> registerDonneur(
            //Mapping le corps httpRequest a un objet
            @RequestBody DonneurSangModel request
    ){
        return ResponseEntity.ok(authenticationService.registerDonneur(request));
    }

    @PostMapping("/Admin/registerSecretaire")
    public ResponseEntity<AuthenticationResponse> registerSercretaire(
            @RequestBody SecretaireModel request
    ){
        return ResponseEntity.ok(authenticationService.registerSercretaire(request));
    }

    @PostMapping("/registerAdmin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.registerAdmin(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
