package pl.maja;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CasaEditriceDAOImpl implements DAOGenerica {

	
	public <T> void salva(T casa) {
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			session.save(casa);
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
		List<CasaEditrice> caseList = new ArrayList();
		
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			
			caseList = session.createQuery("FROM CasaEditrice", CasaEditrice.class).getResultList();
		
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.close();
		
		return caseList;
	}

	
	
	
	public <T> void elimina(T pk) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			CasaEditrice casa = session.find(CasaEditrice.class, pk);
			session.delete(casa);
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
		CasaEditrice casa = new CasaEditrice();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		
			
			casa = session.find(CasaEditrice.class, nome);
			System.out.println(casa);
		
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.close();
		return casa;
	}

}
