package dev.sirhgestionpersonnelwebap.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.sirhgestionpersonnelwebap.entite.Collaborateur;
import dev.sirhgestionpersonnelwebap.repository.CollaborateursRepository;

@Controller
@RequestMapping("/api/collaborateurs")
public class CollaborateursController {
	@Autowired
	private CollaborateursRepository collabRepo;
	
	@PersistenceContext EntityManager em;

	@GetMapping
	@ResponseBody
	public List<Collaborateur> afficherCollaborateurs(@RequestParam(value="departement", required = false) Integer idDep) {
		if(idDep != null) {
			return collabRepo.findByDepartementId(idDep);
		}
		
		return collabRepo.findAll();
	}
	
	@RequestMapping(path = "/{matricule}", method = RequestMethod.GET)
	@ResponseBody
	public Collaborateur afficherCollaborateur(@PathVariable String matricule) {
		return collabRepo.findByMatricule(matricule);
	}
	
//	@RequestMapping(path = "/{matricule}", method = RequestMethod.PUT)
//	@ResponseBody
//	public Collaborateur creerCollaborateur(
//			@PathVariable String matricule, 
//			@RequestParam("nom") String nom, 
//			@RequestParam("nom") String prenom, 
//			@RequestParam("nom") String dateNaissance, 
//			@RequestParam("nom") String adresse, 
//			@RequestParam("nom") String numeroSS, 
//			@RequestParam("nom") String emailPro,
//			@RequestParam("nom") String dateHeureCreation, 
//			@RequestParam("nom") Departement departement
//	) {
//		return collabRepo.findByMatricule(matricule);
//	}
	
	@Transactional
	@PutMapping("/{matricule}")
    public Collaborateur creerCollaborateur(@PathVariable String matricule, @RequestBody Collaborateur collab) {
        // PUT processing
		collab.setMatricule(matricule);
        try{
//        	collabRepo.remove(collabRepo.findByMatricule(matricule).getId());
        	em.persist(collab);
        }catch(Exception e){
            System.out.println(e.getStackTrace());
            return null;
        }
        return collab;
    }
}