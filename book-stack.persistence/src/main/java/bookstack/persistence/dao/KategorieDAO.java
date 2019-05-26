package bookstack.persistence.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import bookstack.persistence.entities.Kategorie;

public class KategorieDAO extends AbstractDAO<Kategorie> {

	public KategorieDAO() {
		super(Kategorie.class);
		
	}
	
	public List<Kategorie> getCategoriesByName(String nazov) {
		TypedQuery<Kategorie> query = em.createNamedQuery("findCategoriesByName", Kategorie.class);
		query.setParameter("nazov", nazov);
		return query.getResultList();
	}
	
	

}
