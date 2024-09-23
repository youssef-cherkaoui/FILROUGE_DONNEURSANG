package fil_rouge.Service;

import fil_rouge.Enums.Region;
import fil_rouge.Enums.Ville;
import fil_rouge.Model.AdresseModel;
import fil_rouge.Repository.AdresseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AdresseServiceImplTest {

    @InjectMocks
    private AdresseServiceImpl adresseService;

    @Mock
    private AdresseRepository adresseRepository;

    private AdresseModel adresse;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        adresse = new AdresseModel();
        adresse.setId(1L);
        adresse.setRue("1 Avenue Mohammed VI");
        adresse.setVille(Ville.TANGIER);
        adresse.setRegion(Region.TANGER_TETOUAN_ALHOCEIMA);
        adresse.setCodePostal("90000");
    }

    @Test
    void createAdresse() {
        when(adresseRepository.save(any(AdresseModel.class))).thenReturn(adresse);

        AdresseModel createdAdresse = adresseService.CreateAdresse(adresse);

        assertNotNull(createdAdresse);
        assertEquals(adresse.getRue(), createdAdresse.getRue());
        verify(adresseRepository, times(1)).save(adresse);
    }

    @Test
    void getAdresseById() {

        when(adresseRepository.findById(1L)).thenReturn(java.util.Optional.of(adresse));

        AdresseModel TrouvailleAdresse = adresseService.GetAdresseById(1L);

        assertNotNull(TrouvailleAdresse);
        assertEquals(adresse.getId(), TrouvailleAdresse.getId());
        verify(adresseRepository, times(1)).findById(1L);
    }

    @Test
    void getAllAdresses() {

        when(adresseRepository.findAll()).thenReturn(List.of(adresse));

        List<AdresseModel> adresses = adresseService.getAllAdresses();

        assertFalse(adresses.isEmpty());
        verify(adresseRepository, times(1)).findAll();
    }

    @Test
    void updateAdresse() {

        when(adresseRepository.findById(1L)).thenReturn(java.util.Optional.of(adresse));
        when(adresseRepository.save(any(AdresseModel.class))).thenReturn(adresse);

        AdresseModel updatedAdresse = new AdresseModel();
        updatedAdresse.setRue("2 Avenue Mohammed VI");
        updatedAdresse.setVille(Ville.TANGIER);
        updatedAdresse.setRegion(Region.TANGER_TETOUAN_ALHOCEIMA);
        updatedAdresse.setCodePostal("20001");

        AdresseModel result = adresseService.updateAdresse(1L, updatedAdresse);

        assertEquals("2 Avenue Mohammed VI", result.getRue());
        verify(adresseRepository, times(1)).save(adresse);
    }

    @Test
    void deleteAdresse() {
        doNothing().when(adresseRepository).deleteById(1L);

        adresseService.deleteAdresse(1L);

        verify(adresseRepository, times(1)).deleteById(1L);
    }

    @Test
    void findAdresseByRegion() {
        when(adresseRepository.findByRegion(Region.TANGER_TETOUAN_ALHOCEIMA)).thenReturn(List.of(adresse));

        List<AdresseModel> adresses = adresseService.findAdresseByRegion(Region.TANGER_TETOUAN_ALHOCEIMA);

        assertNotNull(adresses);
        assertFalse(adresses.isEmpty());
        assertEquals(1, adresses.size());
        assertEquals(adresse.getRegion(), adresses.get(0).getRegion());
        verify(adresseRepository, times(1)).findByRegion(Region.TANGER_TETOUAN_ALHOCEIMA);
    }

    @Test
    void findAdresseByVille() {
        when(adresseRepository.findByVille(Ville.TANGIER)).thenReturn(List.of(adresse));

        // Appel de la méthode à tester
        List<AdresseModel> adresses = adresseService.findAdresseByVille(Ville.TANGIER);

        // Vérifications
        assertNotNull(adresses);
        assertFalse(adresses.isEmpty());
        assertEquals(1, adresses.size());
        assertEquals(adresse.getVille(), adresses.get(0).getVille());
        verify(adresseRepository, times(1)).findByVille(Ville.TANGIER);
    }

    @Test
    void findAdresseByCodePostal() {

        when(adresseRepository.findByCodePostal("90000")).thenReturn(List.of(adresse));

        // Appel de la méthode à tester
        List<AdresseModel> adresses = adresseService.findAdresseByCodePostal("90000");

        // Vérifications
        assertNotNull(adresses);
        assertFalse(adresses.isEmpty());
        assertEquals(1, adresses.size());
        assertEquals(adresse.getCodePostal(), adresses.get(0).getCodePostal());
        verify(adresseRepository, times(1)).findByCodePostal("90000");
    }
}