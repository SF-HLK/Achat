package tn.esprit.rh.achat;

import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurServiceTest {


@Autowired
private FournisseurServiceImpl service;
@MockBean
private FournisseurRepository repository;

public void addFournisseurTest(){
    when(repository.findAll()).thenReturn(Stream.
            of(new Fournisseur(12, "code safa", "libelle safa"), new))

}


}
