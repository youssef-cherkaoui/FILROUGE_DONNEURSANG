package fil_rouge.Service;

import fil_rouge.DTO.AuthenticationRequest;
import fil_rouge.DTO.AuthenticationResponse;
import fil_rouge.DTO.RegisterRequest;
import fil_rouge.Enums.Role;
import fil_rouge.Model.DonneurSangModel;
import fil_rouge.Model.Personne;
import fil_rouge.Model.SecretaireModel;
import fil_rouge.Repository.DonneurSangRepository;
import fil_rouge.Repository.PersonneRepository;
import fil_rouge.Repository.SecretaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PersonneRepository personneRepository;
    private final DonneurSangRepository donneurSangRepository;
    //    private final CentreCollectRepository centreCollectRepository;
//    private final RendezVousReposirory rendezVousReposirory;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final SecretaireRepository secretaireRepository;


    public AuthenticationResponse registerAdmin(RegisterRequest request){

        var user = Personne.builder()
                .nom(request.getNom())
                .email(request.getEmail())
                .telephone(request.getTelephone())
                .groupSanguin(request.getGroupSanguin())
                .motdepasse(passwordEncoder.encode(request.getMotdepasse()))
                .role(Role.ADMIN)
                .build();
        var admin = personneRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return  AuthenticationResponse.builder()
                .token(jwtToken).user(admin)
                .build();
    }


    public AuthenticationResponse registerDonneur(DonneurSangModel request){
        DonneurSangModel donneur = new DonneurSangModel();
        donneur.setNom(request.getNom());
        donneur.setEmail(request.getEmail());
        donneur.setTelephone(request.getTelephone());
        donneur.setGroupSanguin(request.getGroupSanguin());
        donneur.setCentreCollecte(request.getCentreCollecte());
        donneur.setMotdepasse(passwordEncoder.encode(request.getPassword()));
        donneur.setRole(Role.valueOf("DONNEURSANG"));

        System.out.print(donneur);
        var user = donneurSangRepository.save(donneur);

        var jwtToken = jwtService.generateToken(donneur);
        return AuthenticationResponse.builder()
                .token(jwtToken).user(user)
                .build();
    }

    public AuthenticationResponse registerSercretaire(SecretaireModel request){

        SecretaireModel secretaire = new SecretaireModel();
        secretaire.setNom(request.getNom());
        secretaire.setEmail(request.getEmail());
        secretaire.setTelephone(request.getTelephone());
        secretaire.setGroupSanguin(request.getGroupSanguin());
        secretaire.setCentreCollecte(request.getCentreCollecte());
        secretaire.setMotdepasse(passwordEncoder.encode(request.getMotdepasse()));
        secretaire.setRole(Role.valueOf("SECRETAIRE"));

        var secretaire1 = secretaireRepository.save(secretaire);

        var jwtToken = jwtService.generateToken(secretaire);
        return AuthenticationResponse.builder()
                .token(jwtToken).user(secretaire1)
                .build();

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getMotdepasse()
                )
        );

        var user = personneRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user(user)
                .build();
    }
}
