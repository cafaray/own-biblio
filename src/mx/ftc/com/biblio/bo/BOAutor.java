package mx.ftc.com.biblio.bo;

import java.util.List;

import mx.ftc.com.biblio.bo.exception.BOException;
import mx.ftc.com.biblio.model.Autor;
import mx.ftc.com.biblio.model.Libro;
import mx.ftc.com.biblio.model.LibroAutor;

public interface BOAutor {
	Autor registrar(Autor autor) throws BOException;
	Autor actualizar(Autor autor) throws BOException;
	
	LibroAutor registrarLibro(Autor autor, Libro  libro) throws BOException;
	List<Libro> consultarLibros(Autor autor) throws BOException;
	
	List<Autor> listar() throws BOException;
	List<Autor> buscar(String nombreCompleto) throws BOException;
	List<Autor> buscar(String nombre, String apellidos) throws BOException;
	
}	
