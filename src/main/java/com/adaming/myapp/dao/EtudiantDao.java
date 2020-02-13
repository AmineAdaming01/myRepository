package com.adaming.myapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.entity.Etudiant;
@Repository
public class EtudiantDao {

//	public List<Etudiant> etudiants = new ArrayList<Etudiant>();
	
	@Autowired
	private SessionFactory sf;
     
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public void AjoutEtudiant(Etudiant etd) {
         Session session = sf.openSession();
         session.beginTransaction();
         session.save(etd);
         session.getTransaction().commit();
		

	}

	public void SupprimerEtudiant(Etudiant etd) {

		Session session = sf.openSession();
        session.beginTransaction();
        session.delete(etd);
        session.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	public List<Etudiant> getAllEtudiants() {
		Session sess = sf.openSession();
		sess.beginTransaction();
		Criteria crit = sess.createCriteria(Etudiant.class);  ;
		return crit.list();
		
	}
	public Etudiant getEtdbyId(long id) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		Etudiant etd=(Etudiant) sess.get(Etudiant.class,id);
		return etd;
		
		
	}

}
