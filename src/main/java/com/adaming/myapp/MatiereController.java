package com.adaming.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.adaming.myapp.dao.MatiereDao;
import com.adaming.myapp.entity.Matiere;

@Controller
@RequestMapping("/Matiere")
public class MatiereController {
	
	@Autowired
	private MatiereDao matDao;
	
	public MatiereDao getMatDao() {
		return matDao;
	}
	public void setMatDao(MatiereDao matDao) {
		this.matDao = matDao;
	}
	@RequestMapping(value = "/mat2", method = RequestMethod.GET)
	   public ModelAndView init(@ModelAttribute("mat") Matiere matiere, ModelMap model) {
		  
	      return new ModelAndView("matiere").addAllObjects(model);
	   }
	
	@RequestMapping(value="/Ajout" , method= {RequestMethod.POST,RequestMethod.GET})
	public String AjoutMatiere(@ModelAttribute("mat") Matiere matiere, ModelMap model) {
		model.addAttribute("idMatiere", matiere.getIdMatiere());
		model.addAttribute("nomMatiere", matiere.getNomMatiere());
		matDao.AjoutMatiere(matiere);
		
		
		return "redirect:all";
		
		
		
	}
	@RequestMapping(value="/Supprimer" , method=RequestMethod.GET)
	public String SupprimerMatiere(@ModelAttribute("mat") Matiere matiere) {
		
		matDao.SupprimerMatiere(matiere);
		
		
		return "matiere";
		
		
		
	}
	@RequestMapping(value="/all" , method=RequestMethod.GET)
	public String getAllMatieres(@ModelAttribute("mat") Matiere matiere, ModelMap model) {
		
		
		model.addAttribute("listeDesMatières",matDao.getAllMatieres());
		
		
		
		return "matiere";
		
		
		
	}

}
