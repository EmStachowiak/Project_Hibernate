package pl.maja;

import java.util.List;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		CasaEditrice casa1 = new CasaEditrice("Casa1", "Milano", 100, 23400000 );
		CasaEditrice casa2 = new CasaEditrice("Casa2", "Roma", 200, 100000000 );
		
		Manga m1 = new Manga("Manga1", "Abcd", "Rossi", "Bianchi", 50);
		Manga m2 = new Manga("Manga2", "Bcde", "Verdi", "Johnson", 50);
		Manga m3 = new Manga("Manga3", "Cdef", "Trump", "Merkel", 50);
		Manga m4 = new Manga("Manga4", "Defg", "Paretti", "Wiliams", 50);
		Manga m5 = new Manga("Manga5", "Efgh", "Macron", "Bianchi", 50);
		
		List<Manga> list1 = new ArrayList();
		list1.add(m1);
		list1.add(m2);
		list1.add(m3);
		
		casa1.setMangaList(list1);
		
		m1.setCasaEditrice(casa1);
		m2.setCasaEditrice(casa1);
		m3.setCasaEditrice(casa1);
		
		List<Manga> list2 = new ArrayList();
		list2.add(m4);
		list2.add(m5);
		
		casa2.setMangaList(list2);
		
		m4.setCasaEditrice(casa2);
		m5.setCasaEditrice(casa2);
	
		
		DAOGenerica mangaDAO = new MangaDAOImpl();
		DAOGenerica casaDAO = new CasaEditriceDAOImpl();
		
		casaDAO.salva(casa1);
		casaDAO.salva(casa2);
		
		
		
		System.out.println("\n\n-------------------------------------------MANGA: ");
		System.out.println("\nLista tutte manga: ");
		List<Manga> listManga =  (List<Manga>) mangaDAO.estrai();
		listManga.forEach(e->System.out.println(e));
		
		mangaDAO.aggiornaNrVolumi("Manga3", 200);
		mangaDAO.elimina("Manga1");
		Manga m = (Manga) mangaDAO.estraiByNome("Manga3");
		System.out.println(m);
		
		
		System.out.println("\nLista manga dopo aggiornamenti: ");
		List<Manga> listManga2 =  (List<Manga>) mangaDAO.estrai();
		listManga2.forEach(e->System.out.println(e));
		
		
		System.out.println("\n\n-------------------------------------------CASA EDITRICE: ");
		System.out.println("\nLista tutte case editrice: ");
		List<CasaEditrice> listCase =  (List<CasaEditrice>) casaDAO.estrai();
		listCase.forEach(e->System.out.println(e));
		
		
		casaDAO.elimina("Casa1");
		CasaEditrice c = (CasaEditrice) casaDAO.estraiByNome("Casa2");
		System.out.println("Hai cancellato: " + c);
		
		
		System.out.println("\nLista case dopo aggiornamenti: ");
		List<CasaEditrice> listCase2 =  (List<CasaEditrice>) casaDAO.estrai();
		listCase2.forEach(e->System.out.println(e));
		
		
		
		
		
		
		
		
	
	}

}
