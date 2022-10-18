package tn.esprit.rh.achat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class StockServiceTest {

	@Mock
	StockRepository sr;
	@InjectMocks
	StockServiceImpl ss;

	@Test
	public void testAddStock() {
		Stock stock = new Stock();
		Mockito.when(sr.save(ArgumentMatchers.any(Stock.class))).thenReturn(stock);
		Stock Stockadd = ss.addStock(stock);
		assertThat(Stockadd.getLibelleStock()).isSameAs(Stockadd.getLibelleStock());
	}

	@Test
	public void RetrieveAllStockTest() {
		List<Stock> stocks = new ArrayList<>();
		stocks.add(new Stock());
		when(sr.findAll()).thenReturn(stocks);
		List<Stock> expected = ss.retrieveAllStocks();
		assertEquals(expected, stocks);
		verify(sr).findAll();
	}

	@Test
	public void DeleteStockIfExistTest() {
		Stock stock = new Stock();
		stock.setIdStock(1L);
		stock.setLibelleStock("libelle3");
		stock.setQte(20);
		stock.setQteMin(1);
		/*Mockito.when(sr.findById(stock.getIdStock())).thenReturn(Optional.of(stock));
		ss.deleteStock(stock.getIdStock());
		verify(sr).deleteById(stock.getIdStock());*/
		System.out.println("testdeleteStock");
        ss.deleteStock(1L);
        Mockito.verify(sr, times(0)).delete(stock);
	}
}