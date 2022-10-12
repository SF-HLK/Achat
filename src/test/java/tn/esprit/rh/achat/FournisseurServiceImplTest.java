package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Fournisseur;

import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class FournisseurServiceImplTest {

    @Autowired
    FournisseurServiceImpl fournisseur;
    @Test
    @Order(1)
    public void testRetrieveAllFournisseurs() {
        List<Fournisseur> listFournisseur = fournisseur.retrieveAllFournisseurs();
        Assertions.assertEquals(0, listFournisseur.size());
    }
}
