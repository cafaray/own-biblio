package mx.ftc.com.biblio.bo.impl;

import java.util.List;

import mx.ftc.com.biblio.bo.BOLibro;
import mx.ftc.com.biblio.bo.exception.BOException;
import mx.ftc.com.biblio.dao.DAOLibro;
import mx.ftc.com.biblio.dao.exception.BiblioException;
import mx.ftc.com.biblio.dao.impl.DAOLibroImpl;
import mx.ftc.com.biblio.model.Autor;
import mx.ftc.com.biblio.model.Libro;
import mx.ftc.com.biblio.model.LibroAutor;

public class BOLibroImpl implements BOLibro {

	@Override
	public Libro registrar(Libro libro) throws BOException {
		DAOLibro dao = new DAOLibroImpl();
		try {
			libro = dao.save(libro);
			return libro;
		} catch (BiblioException e) {
			throw new BOException(e, -5001);
		}
	}

	@Override
	public Libro actualizar(Libro libro) throws BOException {
		DAOLibro dao = new DAOLibroImpl();
		try {
			libro = dao.update(libro);
			return libro;
		} catch (BiblioException e) {
			throw new BOException(e, -5002);
		}
	}

	@Override
	public void eliminar(Libro libro) throws BOException {
		eliminar(libro.getIdentificador());
	}

	@Override
	public void eliminar(String codigo) throws BOException {
		DAOLibro dao = new DAOLibroImpl();
		try {
			dao.deleteById(codigo);
		} catch (BiblioException e) {			
			throw new BOException(e, -5007);
		}
	}

	@Override
	public Libro encontrar(String codigo) throws BOException {
		DAOLibro dao = new DAOLibroImpl();
		Libro libro;
		try {
			libro = dao.findById(codigo);
			return libro;
		} catch (BiblioException e) {
			throw new BOException(e, -5000);
		}
	}

	@Override
	public List<Libro> buscar(String titulo) throws BOException {
		DAOLibro dao = new DAOLibroImpl();
		try {
			return dao.search(titulo);
		} catch (BiblioException e) {
			throw new BOException("Imposible la búsqueda por titulo", e, -5000);
		}
	}

	@Override
	public List<Libro> buscar(Autor autor) throws BOException {
		DAOLibro dao = new DAOLibroImpl();
		try {
			return dao.search(autor);
		} catch (BiblioException e) {
			throw new BOException("Imposible la búsqueda por autor", e, -5000);
		}
	}

	@Override
	public Libro encontrarPorISBN(String isbn) throws BOException {
		DAOLibro dao = new DAOLibroImpl();
		try {
			return dao.findByISBN(isbn);
		} catch (BiblioException e) {
			throw new BOException("Imposible la búsqueda por ISBN", e, -5000);
		}
	}

	@Override
	public List<Libro> listar() throws BOException {
		DAOLibro dao = new DAOLibroImpl();
		try {
			return dao.findAll();
		} catch (BiblioException e) {
			throw new BOException("Imposible listar el resultado", e, -5000);
		}

	}

	@Override
	public LibroAutor asociarAutores(Libro libro, Autor... autores) throws BOException {
		DAOLibro dao = new DAOLibroImpl();
		try{
			return dao.setAutors(libro, autores);			
		}catch(BiblioException e){
			throw new BOException("Imposible asociar los autores al libro", e, -5001);
		}
	}

}
