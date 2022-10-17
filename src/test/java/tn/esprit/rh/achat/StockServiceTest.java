package tn.esprit.rh.achat;

	import org.junit.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;
	import org.springframework.test.context.junit4.SpringRunner;
	import org.junit.runner.RunWith;
	import tn.esprit.rh.achat.entities.Stock;
	import tn.esprit.rh.achat.repositories.StockRepository;
    import tn.esprit.rh.achat.services.StockServiceImpl;

    import java.util.stream.Collectors;
	import java.util.stream.Stream;

	import static org.junit.Assert.assertEquals;
	import static org.mockito.Mockito.when;

	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class StockServiceTest {

	@Autowired
	private StockServiceImpl service;
	@MockBean
	private StockRepository repository;

	@Test
	public void addStockTest(){
	    System.out.println("hello");
	    when(repository.findAll()).thenReturn(Stream
	            .of(new Stock(12, "libelleStock", 10, 50), new Stock(22, "HANA", 10, 22)).collect(Collectors.toList()));
	    assertEquals(2, service.retrieveAllStocks().size());
	}


	

}
