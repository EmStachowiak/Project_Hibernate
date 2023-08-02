package pl.maja;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manga")
public class Manga {
	
	@Id
	private String nome;
	private String genere;
	private String cognomeScrittore;
	private String cognomeDisegnatore;
	private int numeroVolumi;
	
	
	@ManyToOne
	@JoinColumn(name = "fk_casa_editrice", referencedColumnName = "nome")
	private CasaEditrice casaEditrice;
	
	public Manga() {}

	public Manga(String nome, String genere, String cognomeScrittore, String cognomeDisegnatore, int numeroVolumi) {
		this.nome = nome;
		this.genere = genere;
		this.cognomeScrittore = cognomeScrittore;
		this.cognomeDisegnatore = cognomeDisegnatore;
		this.numeroVolumi = numeroVolumi;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getCognomeScrittore() {
		return cognomeScrittore;
	}

	public void setCognomeScrittore(String cognomeScrittore) {
		this.cognomeScrittore = cognomeScrittore;
	}

	public String getCognomeDisegnatore() {
		return cognomeDisegnatore;
	}

	public void setCognomeDisegnatore(String cognomeDisegnatore) {
		this.cognomeDisegnatore = cognomeDisegnatore;
	}

	public int getNumeroVolumi() {
		return numeroVolumi;
	}

	public void setNumeroVolumi(int numeroVolumi) {
		this.numeroVolumi = numeroVolumi;
	}

	public CasaEditrice getCasaEditrice() {
		return casaEditrice;
	}

	public void setCasaEditrice(CasaEditrice casaEditrice) {
		this.casaEditrice = casaEditrice;
	}

	
	
	@Override
	public String toString() {
		return "Manga- nome=" + nome + ", genere=" + genere + ", cognome scrittore=" + cognomeScrittore
				+ ", cognome disegnatore=" + cognomeDisegnatore + ", numero volumi=" + numeroVolumi;
	}
	

}
