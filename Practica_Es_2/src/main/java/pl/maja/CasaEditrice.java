package pl.maja;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "casa_editrice")
public class CasaEditrice {
	
	@Id
	private String nome;
	private String sedeCentrale;
	private int numeroDipendenti;
	private double fatturato;
	
	@OneToMany(mappedBy = "casaEditrice", cascade = CascadeType.ALL)
	private List<Manga> mangaList;
	
	public CasaEditrice() {}

	public CasaEditrice(String nome, String sedeCentrale, int numeroDipendenti, double fatturato) {
		this.nome = nome;
		this.sedeCentrale = sedeCentrale;
		this.numeroDipendenti = numeroDipendenti;
		this.fatturato = fatturato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSedeCentrale() {
		return sedeCentrale;
	}

	public void setSedeCentrale(String sedeCentrale) {
		this.sedeCentrale = sedeCentrale;
	}

	public int getNumeroDipendenti() {
		return numeroDipendenti;
	}

	public void setNumeroDipendenti(int numeroDipendenti) {
		this.numeroDipendenti = numeroDipendenti;
	}

	public double getFatturato() {
		return fatturato;
	}

	public void setFatturato(double fatturato) {
		this.fatturato = fatturato;
	
		
	}

	public List<Manga> getMangaList() {
		return mangaList;
	}

	public void setMangaList(List<Manga> mangaList) {
		this.mangaList = mangaList;
	}

	@Override
	public String toString() {
		return "Casa editrice- nome: " + nome + ", sede centrale: " + sedeCentrale + ", numero dipendenti: "
				+ numeroDipendenti + ", fatturato=" + fatturato;
	}
	
	
	

}
