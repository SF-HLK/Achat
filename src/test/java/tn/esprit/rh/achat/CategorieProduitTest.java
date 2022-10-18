package tn.esprit.rh.achat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CategorieProduitTest {

@Mock	
CategorieProduitRepository categorieProduitRepository;
@InjectMocks
CategorieProduitServiceImpl categorieProduit;

CategorieProduit c1 = new CategorieProduit (1L,"abc","homme",null);

@Test
public void testRetrievecategorie() {
Mockito.when(categorieProduitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(c1));
CategorieProduit categorie1 = categorieProduit.retrieveCategorieProduit(1L);
Assertions.assertNotNull(categorie1);
}

@Test
public void createcategorieproduitTest()
{
	CategorieProduit cat1 = new CategorieProduit(1L,"abc","homme",null);

	categorieProduit.addCategorieProduit(cat1);

	verify(categorieProduitRepository, times(1)).save(cat1);
}
	
}
