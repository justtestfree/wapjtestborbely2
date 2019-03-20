package bookstack.business;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import bookstack.persistence.dao.BookDAO;

//@Startup
@Singleton
public class MyMain {
	
	@Inject
	private BookDAO bookDao;
	
	@Inject
	private BookService bookService;
	
	
	@PostConstruct
	private void init() {
		System.out.println("MyMain initialization");
		//System.out.println("list size: "+bookDao.getBooksByTitle("example").size());
		
	}
	
	//@Schedule(hour="20", minute="42")
	private void query() {
		System.out.println("list size: "+bookDao.getBooksByTitle("example").size());
		bookService.createNew("sdiidssd", "Druha kniha");
		System.out.println("Uspesne.");
	}

}
