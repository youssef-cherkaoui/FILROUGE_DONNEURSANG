package fil_rouge.Service;

import fil_rouge.Enums.GroupSanguin;
import fil_rouge.Model.CentreCollectModel;
import fil_rouge.Model.DonneurSangModel;
import fil_rouge.Model.RendezVousModel;
import fil_rouge.Repository.CentreCollectRepository;
import fil_rouge.Repository.DonneurSangRepository;
import fil_rouge.Repository.RendezVousRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class DonneurSangServiceImplTest {

    @Mock
    private DonneurSangRepository donneurSangRepository;

    @Mock
    private RendezVousRepository rendezVousRepository;

    @Mock
    private CentreCollectRepository centreCollectRepository;

    @InjectMocks
    private DonneurSangServiceImpl donneurSangService;

    private DonneurSangModel donneur;
    private RendezVousModel rendezVous;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        donneur = new DonneurSangModel();
        donneur.setId(1L);
        donneur.setNom("Test Donneur");
        donneur.setEmail("donneur@example.com");
        donneur.setMotdepasse("password");
        donneur.setTelephone("123456789");
        donneur.setGroupSanguin(GroupSanguin.A_POS);

        rendezVous = new RendezVousModel();
        rendezVous.setId(1L);
        rendezVous.setDate(LocalDate.now());
    }

    @Test
    void createDonneurSang() {
        when(donneurSangRepository.save(donneur)).thenReturn(donneur);

        DonneurSangModel result = donneurSangService.CreateDonneurSang(donneur);

        assertNotNull(result);
        assertEquals(donneur.getNom(), result.getNom());
        verify(donneurSangRepository, times(1)).save(donneur);
    }

    @Test
    void getDonneurSangById() {
        when(donneurSangRepository.findById(donneur.getId())).thenReturn(Optional.of(donneur));

        DonneurSangModel result = donneurSangService.getDonneurSangById(donneur.getId());

        assertNotNull(result);
        assertEquals(donneur.getNom(), result.getNom());
        verify(donneurSangRepository, times(1)).findById(donneur.getId());
    }

    @Test
    void getAllDonneurSang() {
        List<DonneurSangModel> list = new ArrayList<>();
        list.add(donneur);

        when(donneurSangRepository.findAll()).thenReturn(list);

        List<DonneurSangModel> result = donneurSangService.getAllDonneurSang();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(donneur.getNom(), result.get(0).getNom());
        verify(donneurSangRepository, times(1)).findAll();
    }

    @Test
    void updateDonneurSang() {
        when(donneurSangRepository.findById(donneur.getId())).thenReturn(Optional.of(donneur));
        when(donneurSangRepository.save(donneur)).thenReturn(donneur);

        DonneurSangModel updatedDonneur = new DonneurSangModel();
        updatedDonneur.setNom("Updated Donneur");
        updatedDonneur.setEmail("updated@example.com");
        updatedDonneur.setMotdepasse("newpassword");
        updatedDonneur.setTelephone("987654321");
        updatedDonneur.setGroupSanguin(GroupSanguin.B_POS); // Remplace par le bon enum

        DonneurSangModel result = donneurSangService.updateDonneurSang(donneur.getId(), updatedDonneur);

        assertNotNull(result);
        assertEquals("Updated Donneur", result.getNom());
        verify(donneurSangRepository, times(1)).findById(donneur.getId());
        verify(donneurSangRepository, times(1)).save(any());
    }

    @Test
    void deleteDonneurSang() {
        Long id = 1L;

        assertDoesNotThrow(() -> donneurSangService.deleteDonneurSang(id));
        verify(donneurSangRepository, times(1)).deleteById(id);
    }

    @Test
    void getHistoriqueRDV() {
        donneur.setRendezVous(new ArrayList<>());
        rendezVous.setDonneurSang(donneur);
        donneur.getRendezVous().add(rendezVous);

        when(donneurSangRepository.findById(donneur.getId())).thenReturn(Optional.of(donneur));

        List<RendezVousModel> result = donneurSangService.getHistoriqueRDV(donneur.getId());

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(rendezVous.getId(), result.get(0).getId());
    }

    @Test
    void filterByGrpSanguin() {
        List<DonneurSangModel> list = new ArrayList<>();
        list.add(donneur);

        when(donneurSangRepository.findByGroupSanguin(GroupSanguin.A_POS)).thenReturn(list);

        List<DonneurSangModel> result = donneurSangService.filterByGrpSanguin(GroupSanguin.A_POS);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(donneur.getNom(), result.get(0).getNom());
    }

    @Test
    void demanderRDV() {
        when(donneurSangRepository.findById(donneur.getId())).thenReturn(Optional.of(donneur));
        when(rendezVousRepository.save(any(RendezVousModel.class))).thenReturn(rendezVous);

        RendezVousModel result = donneurSangService.demanderRDV(donneur.getId(), rendezVous);

        assertNotNull(result);
        assertEquals(rendezVous.getId(), result.getId());
        verify(rendezVousRepository, times(1)).save(rendezVous);
    }

    @Test
    void rechercherCentre() {
        List<CentreCollectModel> list = new ArrayList<>();
        CentreCollectModel centre = new CentreCollectModel();
        centre.setNomCentre("Centre Test");
        list.add(centre);

        when(centreCollectRepository.findByNomCentre("Centre Test")).thenReturn(list);

        List<CentreCollectModel> result = donneurSangService.rechercherCentre("Centre Test");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Centre Test", result.get(0).getNomCentre());
    }
}