package fil_rouge.Service;

import fil_rouge.Model.RendezVousModel;
import fil_rouge.Repository.RendezVousRepository;
import fil_rouge.Repository.RendezVousSecretaireRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RendezVousSecretaireServiceImplTest {

    @Mock
    private RendezVousRepository rendezVousRepository;

    @InjectMocks
    private RendezVousSecretaireServiceImpl rendezVousService;

    private List<RendezVousModel> rendezVousList;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        rendezVousList = new ArrayList<>();
        RendezVousModel rdv1 = new RendezVousModel();
        RendezVousModel rdv2 = new RendezVousModel();
        rendezVousList.add(rdv1);
        rendezVousList.add(rdv2);

    }

    @Test
    void testGetAllRDV() {
        when(rendezVousRepository.findAll()).thenReturn(rendezVousList);

        List<RendezVousModel> result = rendezVousService.getAllRDV();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(rendezVousRepository, times(1)).findAll();
    }

}