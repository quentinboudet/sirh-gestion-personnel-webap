package dev.sirhgestionpersonnelwebap.listener;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dev.sirhgestionpersonnelwebap.entite.Collaborateur;
import dev.sirhgestionpersonnelwebap.entite.Departement;
import dev.sirhgestionpersonnelwebap.repository.CollaborateursRepository;
import dev.sirhgestionpersonnelwebap.repository.DepartementsRepository;

@Component
public class StartUpAppListener {
	@Autowired
	CollaborateursRepository collabR;
	
	@Autowired
	DepartementsRepository depR;

	@PersistenceContext EntityManager em;

	@Transactional
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		Departement dep1 = new Departement("Lecture");
		Departement dep2 = new Departement("Cartographie");
		Departement dep3 = new Departement("Science");
		
		em.persist(dep1);
		em.persist(dep2);
		em.persist(dep3);
		

		em.persist(new Collaborateur("C001", "Frank", "Anne", "1954-03-20", "bojoi", "541698425485496", "anne.frank@banque.com", "2015-12-20T12:30:30+01:00", dep1));
		em.persist(new Collaborateur("C002", "Dauber", "Marc", "1964-05-20", "bojoi", "541698441565496", "marc.dauber@banque.com", "2015-12-20T12:30:30+01:00", dep3));
	}
}