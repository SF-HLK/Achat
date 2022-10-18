package tn.esprit.rh.achat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional;

import static org.mockito.Matchers.anyLong;
import static org.mockito.ArgumentMatchers.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
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
@RunWith(MockitoJUnitRunner.class)
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
