package pl.maja;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MangaDAOImpl implements DAOGenerica {

	
	
	public <T> void salva(T manga) {
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			session.save(manga);
			transaction.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
		session.close();
		
		
		
	}

	public List<?> estrai() {
		
		Session session = null;
		List<Manga> mangaList = new ArrayList();
		
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			
			mangaList = session.createQuery("FROM Manga", Manga.class).getResultList();
		
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.close();
		
		return mangaList;
	}

	
	
	
	public <T> void elimina(T pk) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Manga m = session.find(Manga.class, pk);
			session.delete(m);
			transaction.commit();
	
			
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
		session.close();
		
	}

	
	
	public void aggiornaNrVolumi(String nome, int numVolumi) {
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Manga m= session.find(Manga.class, nome);
			m.setNumeroVolumi(numVolumi);
			
			session.update(m);
			transaction.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
		session.close();
		
	}

	
	
	public Object estraiByNome(String nome) {
		Session session = null;
		Manga m = new Manga();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		
			m = session.find(Manga.class, nome);
		
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.close();
		return m;
	}

	

}
