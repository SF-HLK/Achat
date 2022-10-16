package tn.esprit.rh.achat;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static tn.esprit.rh.achat.entities.CategorieFournisseur.ORDINAIRE;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurServiceTest {


@Autowired
private FournisseurServiceImpl service;
@MockBean
private FournisseurRepository repository;
DetailFournisseur df = new DetailFournisseur();

@Test
public void addFournisseur(){
    System.out.println("addFournisseur");
    when(repository.findAll()).thenReturn(Stream
            .of(new Fournisseur(12, "code safa", "libelle safa",ORDINAIRE), new Fournisseur(22, "Code HLK","Libelle HLK",ORDINAIRE)).collect(Collectors.toList()));
    assertEquals(2, service.retrieveAllFournisseurs().size());
}
    @Test
    public void retrieveAllFournisseurs() {
        System.out.println("retrieveAllFournisseurs");
        Fournisseur fournisseur = new Fournisseur(12, "Safa", "HLK", ORDINAIRE);
        when(repository.save(fournisseur)).thenReturn(fournisseur);
        assertEquals(fournisseur, service.addFournisseur(fournisseur));

    }
}
