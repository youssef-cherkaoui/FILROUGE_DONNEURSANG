package fil_rouge.Service;

import fil_rouge.Enums.GroupSanguin;
import fil_rouge.Model.SecretaireModel;
import fil_rouge.Repository.SecretaireRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
class SecretaireServiceImplTest {

    @Mock
    private SecretaireRepository secretaireRepository;

    @InjectMocks
    private SecretaireServiceImpl secretaireService;

    private SecretaireModel secretaire;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        secretaire = new SecretaireModel();
        secretaire.setId(1L);
        secretaire.setNom("YOUFESS");
        secretaire.setEmail("YOUFESS@GMAIL.com");
        secretaire.setMotdepasse("1234");
        secretaire.setTelephone("123456789");
        secretaire.setGroupSanguin(GroupSanguin.O_POS);
    }

    @Test
    void ajouterSecretaire() {

        when(secretaireRepository.save(secretaire)).thenReturn(secretaire);

        SecretaireModel result = secretaireService.AjouterSecretaire(secretaire);

        assertNotNull(result);
        assertEquals(secretaire.getNom(), result.getNom());
        verify(secretaireRepository, times(1)).save(secretaire);
    }

    @Test
    void getAllSecretaire() {

        List<SecretaireModel> list = new ArrayList<>();
        list.add(secretaire);

        when(secretaireRepository.findAll()).thenReturn(list);

        List<SecretaireModel> result = secretaireService.getAllSecretaire();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(secretaire.getNom(), result.get(0).getNom());
        verify(secretaireRepository, times(1)).findAll();
    }

    @Test
    void deleteSecretaire() {

        Long id = 1L;

        assertDoesNotThrow(() -> secretaireService.deleteSecretaire(id));
        verify(secretaireRepository, times(1)).deleteById(id);
    }
    @Test
    void updateSecretaire() {
        when(secretaireRepository.findById(secretaire.getId())).thenReturn(Optional.of(secretaire));
        when(secretaireRepository.save(any(SecretaireModel.class))).thenReturn(secretaire);

        SecretaireModel updatedSecretaire = new SecretaireModel();
        updatedSecretaire.setNom("YOUSSEF");
        updatedSecretaire.setEmail("YOUSSEF@gmail.com");
        updatedSecretaire.setMotdepasse("AZER");
        updatedSecretaire.setTelephone("987654321");
        updatedSecretaire.setGroupSanguin(GroupSanguin.O_POS);

        SecretaireModel result = secretaireService.updateSecretaire(secretaire.getId(), updatedSecretaire);

        assertNotNull(result);
        assertEquals("YOUSSEF", result.getNom());

        verify(secretaireRepository, times(1)).findById(secretaire.getId());
        verify(secretaireRepository, times(1)).save(any(SecretaireModel.class));
    }


}