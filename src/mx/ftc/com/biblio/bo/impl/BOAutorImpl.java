package mx.ftc.com.biblio.bo.impl;

import java.util.List;

import mx.ftc.com.biblio.bo.BOAutor;
import mx.ftc.com.biblio.bo.exception.BOException;
import mx.ftc.com.biblio.dao.DAOAutor;
import mx.ftc.com.biblio.dao.DAOLibro;
import mx.ftc.com.biblio.dao.DAOLibroAutor;
import mx.ftc.com.biblio.dao.exception.BiblioException;
import mx.ftc.com.biblio.dao.impl.DAOAutorImpl;
import mx.ftc.com.biblio.dao.impl.DAOLibroAutorImpl;
import mx.ftc.com.biblio.dao.impl.DAOLibroImpl;
import mx.ftc.com.biblio.model.Autor;
import mx.ftc.com.biblio.model.Libro;
import mx.ftc.com.biblio.model.LibroAutor;

public class BOAutorImpl implements BOAutor {

	@Override
	public Autor registrar(Autor autor) throws BOException {
		DAOAutor dao = new DAOAutorImpl();
		try{
			autor = dao.save(autor);
			return autor;
		} catch(BiblioException e){
			throw new BOException(e, -5001);
		}
	}

	@Override
	public Autor actualizar(Autor autor) throws BOException {
		DAOAutor dao = new DAOAutorImpl();
		try{
			autor = dao.save(autor);
			return autor;
		} catch(BiblioException e){
			throw new BOException(e, -5002);
		}
	}

	@Override
	public LibroAutor registrarLibro(Autor autor, Libro libro) throws BOException {
		DAOLibroAutor dao = new DAOLibroAutorImpl();
		try{
			LibroAutor libroAutor = new LibroAutor();
			libroAutor.setLibro(libro);
			libroAutor.setAutor(autor);
			libroAutor = dao.save(libroAutor);
			return libroAutor;
		}catch(BiblioException e){
			throw new BOException("Imposible asociar el libro al autor especificado.", e, 5001);
		}
	}

	@Override
	public List<Libro> consultarLibros(Autor autor) throws BOException {
		DAOLibro dao = new DAOLibroImpl();
		try{
			List<Libro> libros = dao.search(autor);
			return libros;
		} catch(BiblioException e){
			throw new BOException("Imposible realizar la búsqueda de libro por autor.", e, -5000);
		}
	}

	@Override
	public List<Autor> listar() throws BOException {
		DAOAutor dao = new DAOAutorImpl();
		try{
			List<Autor> autores = dao.findAll();
			return autores;
		} catch(BiblioException e){
			throw new BOException("Imposible listar los resultados.", e, -5000);
		}
	}

	@Override
	public List<Autor> buscar(String nombreCompleto) throws BOException {
		try {
			DAOAutor dao = new DAOAutorImpl();
			List<Autor> autores;
			autores = dao.search(nombreCompleto);
			return autores;
		} catch (BiblioException e) {
			throw new BOException("Imposible realizar la búsqueda por nombre completo de Autor.", e, -5000);
		}
	}

	@Override
	public List<Autor> buscar(String nombre, String apellidos) throws BOException {
		try {
			DAOAutor dao = new DAOAutorImpl();
			List<Autor> autores;
			autores = dao.search(nombre, apellidos);
			return autores;
		} catch (BiblioException e) {
			throw new BOException("Imposible realizar la búsqueda por nombre y apellidos de Autor.", e, -5000);
		}
	}

}
