package dev.sirhgestionpersonnelwebap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sirhgestionpersonnelwebap.entite.Collaborateur;

public interface CollaborateursRepository  extends JpaRepository<Collaborateur, Integer>{

	public List<Collaborateur> findByDepartementId(int id);
	
	public Collaborateur findByMatricule(String matricule);

}
