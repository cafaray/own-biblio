package mx.ftc.com.biblio.dao;

import java.util.List;

import mx.ftc.com.biblio.dao.exception.BiblioException;
import mx.ftc.com.biblio.model.Autor;

public interface DAOAutor extends DAOGeneric<Autor, String> {
	List<Autor> search(String nombre, String apellidos) throws BiblioException;
	List<Autor> search(String nombreCompleto) throws BiblioException;
	void delete(Autor autor) throws BiblioException;
	
}
