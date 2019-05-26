package bookstack.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//nazov kategorie musi byt jedinecny
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "nazov" }))
@Entity
@NamedQueries({
		@NamedQuery(name = "findCategoriesByName", query = "SELECT k FROM Kategorie k WHERE k.nazov = :nazov") })

public class Kategorie {

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String nazov;

	@OneToMany(mappedBy = "kategoria")
	private List<Book> books;

	public Kategorie() {
	}

	public Kategorie(String nazov) {
		this.nazov = nazov;
		this.books = new ArrayList<>();
	}

	public String getNazov() {
		return nazov;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
