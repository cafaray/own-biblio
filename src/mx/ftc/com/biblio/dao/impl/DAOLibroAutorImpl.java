package mx.ftc.com.biblio.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import mx.ftc.com.biblio.dao.DAOLibroAutor;
import mx.ftc.com.biblio.dao.exception.BiblioException;
import mx.ftc.com.biblio.model.Autor;
import mx.ftc.com.biblio.model.Libro;
import mx.ftc.com.biblio.model.LibroAutor;

public class DAOLibroAutorImpl extends DAOGenericImpl<LibroAutor, String> implements DAOLibroAutor {
	
	@Override
	public List<LibroAutor> search(Autor autor) throws BiblioException {
		EntityManager em = factory.createEntityManager();
		try{
			TypedQuery<LibroAutor> sentencia = em.createNamedQuery("LibroAutor.findByAutor", LibroAutor.class);
			sentencia.setParameter("identificadorAutor", autor.getIdentificador());
			return sentencia.getResultList();
		} catch(PersistenceException e){
			throw new BiblioException(e);			
		}		
	}

	@Override
	public List<LibroAutor> search(Libro libro) throws BiblioException {
		EntityManager em = factory.createEntityManager();
		try{
			TypedQuery<LibroAutor> sentencia = em.createNamedQuery("LibroAutor.findByLibro", LibroAutor.class);
			sentencia.setParameter("identificadorLibro", libro.getIdentificador());
			return sentencia.getResultList();
		} catch(PersistenceException e){
			throw new BiblioException(e);			
		}		
	}

}
