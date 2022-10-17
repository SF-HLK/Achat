package tn.esprit.rh.achat;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
//import static org.springframework.test.util.AssertionErrors.assertNotNull;
import static tn.esprit.rh.achat.entities.CategorieFournisseur.ORDINAIRE;
import static tn.esprit.rh.achat.entities.CategorieFournisseur.CONVENTIONNE;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceTest {

    @Mock
    FournisseurRepository fournisseurRepository;

    @InjectMocks
   FournisseurServiceImpl fournisseurService;

    Fournisseur f1 = new Fournisseur(12L, "Code Safa","Libelle HLK",ORDINAIRE);


    @Test
    public void retrieveFournisseurs() {
        //System.out.println("retrieveFournisseurs");
        Mockito.when(fournisseurRepository.findById(12L)).thenReturn(Optional.of(f1));
        Fournisseur fournisseur1 = fournisseurService.retrieveFournisseur(12L);
        Assertions.assertNotNull(fournisseur1);
    }

}
