package com.adaming.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.dao.EtudiantDao;
import com.adaming.myapp.entity.Etudiant;


@Controller
@RequestMapping("/Etudiant")
public class EtudiantController {
	@Autowired
	private EtudiantDao etdDao;
	
	public EtudiantDao getEtdDao() {
		return etdDao;
	}
	public void setEtdDao(EtudiantDao etdDao) {
		this.etdDao = etdDao;
	}
	@RequestMapping(value="/init" , method=RequestMethod.GET)
	public String init(@ModelAttribute("etd") Etudiant etud,ModelMap model) {
		model.addAttribute("idEtudiant", etud.getIdEtudiant());
		model.addAttribute("nomEtudiant", etud.getNomEtudiant());
	//	etud = new Etudiant();
		return "redirect:all";
		
		
	}
	
	
	@RequestMapping(value="/Ajout" , method= {RequestMethod.POST,RequestMethod.GET})
	public String AjoutEtudiant(@ModelAttribute("etd") Etudiant etd, ModelMap model) {
		model.addAttribute("idEtudiant", etd.getIdEtudiant());
		model.addAttribute("nomEtudiant", etd.getNomEtudiant());
		etdDao.AjoutEtudiant(etd);
		
		
		return "redirect:all";
		
		
		
	}
	@RequestMapping(value="/Supprimer" , method=RequestMethod.GET)
	public String SupprimerEtudiant(@ModelAttribute("etd") Etudiant etudiant) {
		
		etdDao.SupprimerEtudiant(etudiant);
		
		
		return "etudiant";
		
		
		
	}
	@RequestMapping(value="/all" , method=RequestMethod.GET)
	public String getAllEtudiants(@ModelAttribute("etd") Etudiant etudiant,ModelMap model) {
		
		
		model.addAttribute("listeDesEtudiants",etdDao.getAllEtudiants());
		
		
		
		return "etudiant";
		
		
		
	}
}
