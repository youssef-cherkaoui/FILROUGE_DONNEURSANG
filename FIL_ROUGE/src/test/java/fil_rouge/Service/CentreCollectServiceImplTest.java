package fil_rouge.Service;

import fil_rouge.Model.AdresseModel;
import fil_rouge.Model.CentreCollectModel;
import fil_rouge.Repository.AdresseRepository;
import fil_rouge.Repository.CentreCollectRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
class CentreCollectServiceImplTest {

    @Mock
    private CentreCollectRepository centreCollectRepository;

    @Mock
    private AdresseRepository adresseRepository;

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private CentreCollectServiceImpl centreCollectService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addCentreCollect() {
        CentreCollectModel centreCollect = new CentreCollectModel();
        centreCollect.setNomCentre("Centre Testeuuuuur");

        when(centreCollectRepository.save(any(CentreCollectModel.class))).thenReturn(centreCollect);

        CentreCollectModel savedCentre = centreCollectService.AddCentreCollect(centreCollect);

        assertNotNull(savedCentre);
        assertEquals("Centre Testeuuuuur",savedCentre.getNomCentre());
        verify(centreCollectRepository, times(1)).save(centreCollect);


    }

    @Test
    void getAllCentreCollect() {

        List<CentreCollectModel> centres = Arrays.asList(new CentreCollectModel(), new CentreCollectModel());
        when(centreCollectRepository.findAll()).thenReturn(centres);

        List<CentreCollectModel> result = centreCollectService.getAllCentreCollect();

        assertEquals(2, result.size());
        verify(centreCollectRepository, times(1)).findAll();
    }

    @Test
    void findByNomCentre() {

        String nomCentre = "Centre Tessssst";
        List<CentreCollectModel> centres = Arrays.asList(new CentreCollectModel(), new CentreCollectModel());

        when(centreCollectRepository.findByNomCentre(nomCentre)).thenReturn(centres);

        List<CentreCollectModel> result = centreCollectService.findByNomCentre(nomCentre);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(centreCollectRepository, times(1)).findByNomCentre(nomCentre);
    }

    @Test
    void updateCentre() {

        Long id = 1L;
        CentreCollectModel existCentre = new CentreCollectModel();
        existCentre.setId(id);
        existCentre.setNomCentre("Smiya 9dima");

        CentreCollectModel updatedCentre = new CentreCollectModel();
        updatedCentre.setNomCentre("Smiya Jdidaaaa");

        when(centreCollectRepository.findById(id)).thenReturn(java.util.Optional.of(existCentre));
        when(centreCollectRepository.save(any(CentreCollectModel.class))).thenReturn(updatedCentre);

        CentreCollectModel result = centreCollectService.updateCentre(id, updatedCentre);

        assertNotNull(result);
        assertEquals("Smiya Jdidaaaa", result.getNomCentre());
        verify(centreCollectRepository, times(1)).findById(id);
        verify(centreCollectRepository , times(1)).save(existCentre);
    }

    @Test
    void getCentreById() {

        Long id = 1L;
        CentreCollectModel centre = new CentreCollectModel();
        centre.setId(id);

        when(centreCollectRepository.findById(id)).thenReturn(java.util.Optional.of(centre));

        CentreCollectModel result = centreCollectService.getCentreById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(centreCollectRepository , times(1)).findById(id);
    }

    @Test
    void deleteCentreCollecte() {

        Long id = 1L;

        doNothing().when(centreCollectRepository).deleteById(id);

        centreCollectService.deleteCentreCollecte(id);

        verify(centreCollectRepository, times(1)).deleteById(id);
    }

    @Test
    void assignAdresseToCentre() {

        Long id = 1L ;
        CentreCollectModel centre = new CentreCollectModel();
        AdresseModel adresse = new AdresseModel();
        centre.setId(id);

        when (centreCollectRepository.findById(id)).thenReturn(java.util.Optional.of(centre));
        when (adresseRepository.save(any(AdresseModel.class))).thenReturn(adresse);
        when (centreCollectRepository.save(any(CentreCollectModel.class))).thenReturn(centre);

        CentreCollectModel result = centreCollectService.AssignAdresseToCentre(id, adresse);

        assertNotNull(result);
        assertEquals(adresse, result.getAdresse());
        verify(adresseRepository, times(1)).save(adresse);
        verify(centreCollectRepository , times(1)).save(centre);

    }

    @Test
    void getAdressByCentre() {

        Long id = 1L;
        CentreCollectModel centre = new CentreCollectModel();
        AdresseModel adresse = new AdresseModel();
        centre.setAdresse(adresse);
        centre.setId(id);

        when(centreCollectRepository.findById(id)).thenReturn(java.util.Optional.of(centre));

        AdresseModel result = centreCollectService.getAdressByCentre(id);

        assertNotNull(result);
        assertEquals(adresse, result);
        verify(centreCollectRepository, times(1)).findById(id);
    }
}