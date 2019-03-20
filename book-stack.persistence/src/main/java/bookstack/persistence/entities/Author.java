package bookstack.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Author
 *
 */

//dvojica meno+priezvisko musi byt jedinecna
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "name", "surname"}))
@Entity
@NamedQueries({
	@NamedQuery(name = "findBooksByNames", query = "SELECT a FROM Author a WHERE a.name LIKE :name AND a.surname LIKE :surname")
})
public class Author implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String surname;
	
	@OneToMany(mappedBy = "autor")
	private List<Book> books;
	
	public Author() {
		
	}
	
public Author(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.books = new ArrayList<>();
	}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getSurname() {
	return surname;
}

public void setSurname(String surname) {
	this.surname = surname;
}

public List<Book> getBooks() {
	return books;
}

public void setBooks(List<Book> books) {
	this.books = books;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}


   
}
