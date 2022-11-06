package tn.esprit.spring.service;

import tn.esprit.rh.achat.entities.DetailFacture;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplMock {
	

	@Mock
	ProduitRepository produitRepository;
	
	@InjectMocks
	ProduitServiceImpl produitserver;
	
	
	Produit produit = new Produit("p1","a1", 14,new Date(),new Date(),1,1);
	
	List<Produit> listProduits = new ArrayList<Produit>() {
		
		{
		 add(new Produit("a2","p2", 16,new Date(), new Date(),2,2 ));	
		 add(new Produit("a3","p3", 16,new Date(), new Date(),3,3 ));	
		 
			
		}
		
		@Test
		public void testRetrieveproduits() {
		Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
		Produit produit1 = produitserver.retrieveProduit((long) 1);
		Assertions.assertNotNull(produit1);
		}
		
		
	};
	

}
