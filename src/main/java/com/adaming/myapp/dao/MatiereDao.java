package com.adaming.myapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.entity.Matiere;

@Repository
public class MatiereDao {

//	public List<Matiere> matieres = new ArrayList<Matiere> ();
	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public void AjoutMatiere(Matiere mat) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(mat);
		session.getTransaction().commit();

	}

	public void SupprimerMatiere(Matiere mat) {

		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(mat);
		session.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	public List<Matiere> getAllMatieres() {
		Session sess = sf.openSession();
		sess.beginTransaction();
		Criteria crit = sess.createCriteria(Matiere.class);
		;
		return crit.list();

	}

}
