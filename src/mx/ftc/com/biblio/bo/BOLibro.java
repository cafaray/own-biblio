package mx.ftc.com.biblio.bo;

import java.util.List;

import mx.ftc.com.biblio.bo.exception.BOException;
import mx.ftc.com.biblio.model.Autor;
import mx.ftc.com.biblio.model.Libro;
import mx.ftc.com.biblio.model.LibroAutor;

public interface BOLibro {
	
	Libro registrar(Libro libro) throws BOException;
	Libro actualizar(Libro libro) throws BOException;
	void eliminar(Libro libro) throws BOException;
	void eliminar(String codigo) throws BOException;
	Libro encontrar(String codigo) throws BOException;
	List<Libro> buscar(String titulo) throws BOException;
	List<Libro> buscar(Autor autor) throws BOException;
	Libro encontrarPorISBN(String isbn) throws BOException;
	List<Libro> listar() throws BOException;
	LibroAutor asociarAutores(Libro libro, Autor...autores) throws BOException;
}
