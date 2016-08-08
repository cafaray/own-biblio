package mx.ftc.com.biblio.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import mx.ftc.com.biblio.dao.DAOLibro;
import mx.ftc.com.biblio.dao.DAOLibroAutor;
import mx.ftc.com.biblio.dao.exception.BiblioException;
import mx.ftc.com.biblio.model.Autor;
import mx.ftc.com.biblio.model.Libro;
import mx.ftc.com.biblio.model.LibroAutor;

public class DAOLibroImpl extends DAOGenericImpl<Libro, String> implements DAOLibro {

	@Override
	public void deleteById(String id) throws BiblioException {
		Libro libro = findById(id);
		if(libro!=null){
			delete(libro);
		}
	}

	@Override
	public List<Libro> search(String titulo) throws BiblioException {
		try {
			EntityManager em = factory.createEntityManager();
			TypedQuery<Libro> sentencia = em.createNamedQuery("Libro.findByTitulo", Libro.class);
			sentencia.setParameter("titulo", titulo);
			return sentencia.getResultList();
		}catch(PersistenceException e) {
			throw new BiblioException("Imposible establecer respuesta desde la unidad de persistencia.", e);
		}
	}

	@Override
	public Libro findByISBN(String isbn) throws BiblioException {
		try {
			EntityManager em = factory.createEntityManager();
			TypedQuery<Libro> sentencia = em.createNamedQuery("Libro.findByISBN", Libro.class);
			sentencia.setParameter("isbn", isbn);
			List<Libro> libros = sentencia.getResultList();
			if(libros.size()>0){
				return libros.get(0);
			} else {
				return null;				
			}
		}catch(PersistenceException e) {
			throw new BiblioException("Imposible establecer respuesta desde la unidad de persistencia.", e);
		}
	}

	@Override
	public List<Libro> search(Autor autor) throws BiblioException {
		try {
			EntityManager em = factory.createEntityManager();
			TypedQuery<Libro> sentencia = em.createNamedQuery("Libro.findByAutor", Libro.class);
			sentencia.setParameter("identificadorAutor", autor.getIdentificador());
			List<Libro> libros = sentencia.getResultList();
			return libros;
		}catch(PersistenceException e) {
			throw new BiblioException("Imposible establecer respuesta desde la unidad de persistencia.", e);
		}
	}

	@Override
	public LibroAutor setAutors(Libro libro, Autor... autores) throws BiblioException {
		DAOLibroAutor dao = new DAOLibroAutorImpl();
		try{
			LibroAutor libroAutor = null;
			for(Autor autor:autores){
				libroAutor = new LibroAutor();
				libroAutor.setLibro(libro);
				libroAutor.setAutor(autor);
				dao.save(libroAutor);
			}			
			return libroAutor;
		}catch(BiblioException e){
			throw new BiblioException(e);
		}
	}

	
	

}
