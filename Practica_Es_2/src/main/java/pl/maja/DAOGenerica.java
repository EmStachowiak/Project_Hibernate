package pl.maja;

import java.util.List;

public interface DAOGenerica {
	
	public <T> void salva(T instance);
	
	public List<?> estrai();
	
	public <T> void elimina(T pk);
	
	public void aggiornaNrVolumi(String nome, int numVolumi);	
	
	public default Object estraiByNome(String nome) {
		System.out.println("Un metodo solo per manga");
		return null;
	}
	
}
