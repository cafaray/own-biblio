package mx.ftc.com.biblio.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.ftc.com.biblio.dao.DAOAutor;
import mx.ftc.com.biblio.dao.exception.BiblioException;
import mx.ftc.com.biblio.model.Autor;

public class DAOAutorImpl extends DAOGenericImpl<Autor, String> implements DAOAutor {

	@Override
	public List<Autor> search(String nombre, String apellidos) throws BiblioException {
		EntityManager em = factory.createEntityManager();
		TypedQuery<Autor> sentencia = em.createNamedQuery("Autor.findByNombreApellidos", Autor.class);
		sentencia.setParameter("nombre", nombre);
		sentencia.setParameter("apellidos", apellidos);
		List<Autor> autores = sentencia.getResultList();
		if(autores.size()>0){
			return autores;
		} else {
			return null;
		}
	}

	@Override
	public List<Autor> search(String nombreCompleto) throws BiblioException {
		EntityManager em = factory.createEntityManager();
		TypedQuery<Autor> sentencia = em.createNamedQuery("Autor.findByNombreCompleto", Autor.class);
		sentencia.setParameter("nombreCompleto", nombreCompleto);
		List<Autor> autores = sentencia.getResultList();
		if(autores.size()>0){
			return autores;
		} else {
			return null;
		}
	}

	@Override
	public void delete(Autor autor) throws BiblioException {
		throw new BiblioException("La aplicación no permite eliminar a un autor.");
	}
	
}
