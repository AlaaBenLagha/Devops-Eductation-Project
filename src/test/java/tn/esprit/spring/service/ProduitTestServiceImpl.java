package tn.esprit.spring.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ProduitTestServiceImpl {
	
	
	
	@Autowired
	IProduitService pd;
	
	
	public void testRetrieveAllProduits() {
		List<Produit> listProduits = pd.retrieveAllProduits();
		Assertions.assertEquals(0, listProduits.size());
	}

}
