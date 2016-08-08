package mx.ftc.com.biblio.dao;

import java.util.List;

import mx.ftc.com.biblio.dao.exception.BiblioException;
import mx.ftc.com.biblio.model.Autor;
import mx.ftc.com.biblio.model.Libro;
import mx.ftc.com.biblio.model.LibroAutor;

public interface DAOLibroAutor extends DAOGeneric<LibroAutor, String> {
	
	List<LibroAutor> search(Autor autor) throws BiblioException;
	List<LibroAutor> search(Libro libro) throws BiblioException;
}
