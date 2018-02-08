package dev.sirhgestionpersonnelwebap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.sirhgestionpersonnelwebap.repository.DepartementsRepository;

@Controller
@RequestMapping("/api/departements")
public class DepartementsController {
	@Autowired
	private DepartementsRepository depRepo;

	@GetMapping
	public ModelAndView afficherDepartements() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("departements/index");
		mv.addObject("listDepartement", depRepo.findAll());
		return mv;
	}
}