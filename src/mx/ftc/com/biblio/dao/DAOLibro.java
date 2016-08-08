package mx.ftc.com.biblio.dao;

import java.util.List;

import mx.ftc.com.biblio.dao.exception.BiblioException;
import mx.ftc.com.biblio.model.Autor;
import mx.ftc.com.biblio.model.Libro;
import mx.ftc.com.biblio.model.LibroAutor;

public interface DAOLibro extends DAOGeneric<Libro, String> {
	void deleteById(String id) throws BiblioException;
	List<Libro> search(String titulo) throws BiblioException;
	Libro findByISBN(String isbn) throws BiblioException;
	List<Libro> search(Autor autor) throws BiblioException;
	LibroAutor setAutors(Libro libro, Autor...autores) throws BiblioException;
}
