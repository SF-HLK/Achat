package tn.esprit.rh.achat;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
//import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactureServiceTest {


@Autowired
private FactureServiceImpl service;
@MockBean
private FournisseurRepository repository;
//DetailFournisseur df = new DetailFournisseur();

@Test
public void addFactureTest(){
    System.out.println("bjjjjr");
    when(repository.findAll()).thenReturn(Stream
            .of(new Facture(12, 6,7,"bbb"), new Facture(22,8,9,"kkkk")).collect(Collectors.toList()));
    assertEquals(2, service.retrieveAllFacture().size());
}


}
