package mx.ftc.com.biblio.bo.impl;

import java.util.List;

import mx.ftc.com.biblio.bo.BOLibro;
import mx.ftc.com.biblio.bo.exception.BOException;
import mx.ftc.com.biblio.dao.DAOLibro;
import mx.ftc.com.biblio.dao.exception.BiblioException;
import mx.ftc.com.biblio.dao.impl.DAOLibroImpl;
import mx.ftc.com.biblio.model.Autor;
import mx.ftc.com.biblio.model.Libro;

public class BOLibroImpl implements BOLibro {

	@Override
	public Libro registrar(Libro libro) throws BOException {
		DAOLibro dao = new DAOLibroImpl();
		try {
			libro = dao.save(libro);
			return libro;
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BOException("Imposible registrar el libro, paso una excepción que no lo permite.", e);
		}
	}

	@Override
	public Libro actualizar(Libro libro) throws BOException {
		DAOLibro dao = new DAOLibroImpl();
		try {
			libro = dao.update(libro);
			return libro;
		} catch (BiblioException e) {
			e.printStackTrace();
			throw new BOException("Imposible actualizar el libro, paso una excepción que no lo permite.", e);
		}
	}

	@Override
	public void eliminar(Libro libro) throws BOException {
		
	}

	@Override
	public void eliminar(String codigo) throws BOException {
		
	}

	@Override
	public Libro encontrar(String codigo) throws BOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> buscar(String titulo) throws BOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> buscar(Autor autor) throws BOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro encontrarPorISBN(String isbn) throws BOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> listar() throws BOException {
		// TODO Auto-generated method stub
		return null;
	}

}
