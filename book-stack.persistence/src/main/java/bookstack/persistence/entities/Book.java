package bookstack.persistence.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQueries({
	@NamedQuery(name = "findBooksByTitle", query = "SELECT b FROM Book b WHERE b.title = :title")
})
public class Book implements Serializable {

	private static final long serialVersionUID = -7759431903190558099L;
	
	@Id @GeneratedValue
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "isbn")
	private String isbn;
	
		
	@ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "author")
	private Author autor;
	
	public Book() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Author getAutor() {
		return autor;
	}

	public void setAutor(Author autor) {
		this.autor = autor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	/*
	 * Getters and setters
	 */
}
