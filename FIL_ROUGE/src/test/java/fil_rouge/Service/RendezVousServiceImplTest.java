package fil_rouge.Service;

import fil_rouge.Enums.Status;
import fil_rouge.Model.CentreCollectModel;
import fil_rouge.Model.DonneurSangModel;
import fil_rouge.Model.RendezVousModel;
import fil_rouge.Repository.RendezVousRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
class RendezVousServiceImplTest {

    @Mock
    private RendezVousRepository rendezVousRepository;

    @InjectMocks
    private RendezVousServiceImpl rendezVousService;

    private RendezVousModel rendezVousModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        rendezVousModel = new RendezVousModel();
        CentreCollectModel centreCollectModel = new CentreCollectModel();
        centreCollectModel.setNomCentre("Centre de Tanger");
        rendezVousModel.setCentreCollecte(centreCollectModel);
        rendezVousModel.setDate(LocalDate.now());
        rendezVousModel.setDonneurSang(new DonneurSangModel());
        rendezVousModel.setStatus(Status.NON_VERIFIER);
    }

    @Test
    void createRendezVous() {
        ArgumentCaptor<RendezVousModel> rdvCaptor = ArgumentCaptor.forClass(RendezVousModel.class);
        when(rendezVousRepository.save(any(RendezVousModel.class))).thenReturn(rendezVousModel);

        RendezVousModel createdRDV = rendezVousService.CreateRendezVous(rendezVousModel);

        assertNotNull(createdRDV);
        assertEquals("Centre de Tanger", createdRDV.getCentreCollecte().getNomCentre());
        assertEquals(Status.NON_VERIFIER, createdRDV.getStatus());
        verify(rendezVousRepository, times(1)).save(rdvCaptor.capture());

        RendezVousModel captureRDV = rdvCaptor.getValue();
        assertEquals("Centre de Tanger", captureRDV.getCentreCollecte().getNomCentre());
        assertEquals(Status.NON_VERIFIER, captureRDV.getStatus());

    }


    @Test
    void getAllRDV() {

        List<RendezVousModel> rdvList = new ArrayList<>();
        rdvList.add(rendezVousModel);

        when(rendezVousRepository.findAll()).thenReturn(rdvList);

        List<RendezVousModel> recupererRDV = rendezVousService.getAllRDV();

        assertNotNull(recupererRDV);
        assertEquals(1, recupererRDV.size());
        assertEquals("Centre de Tanger", recupererRDV.get(0).getCentreCollecte().getNomCentre());
        verify(rendezVousRepository, times(1)).findAll();
    }

    @Test
    void deleteRDV() {

        Long rdvId = 1L;
        doNothing().when(rendezVousRepository).deleteById(rdvId);

        rendezVousService.deleteRDV(rdvId);

        verify(rendezVousRepository, times(1)).deleteById(rdvId);
    }

    @Test
    void updateRDV() {

        Long rdvID = 1L;

        RendezVousModel existRDV = new  RendezVousModel();
        existRDV.setId(rdvID);
        existRDV.setStatus(Status.VERIFIER);

        when(rendezVousRepository.findById(rdvID)).thenReturn(Optional.of(existRDV));
        when(rendezVousRepository.save(any(RendezVousModel.class))).thenReturn(existRDV);

        RendezVousModel updatedRDV = rendezVousService.updateRDV(rdvID, existRDV);

        assertNotNull(updatedRDV);
        assertEquals(Status.VERIFIER, updatedRDV.getStatus());
        verify(rendezVousRepository, times(1)).save(existRDV);

    }
}