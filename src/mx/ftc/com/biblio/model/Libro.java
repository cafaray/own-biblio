package mx.ftc.com.biblio.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the libro database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l"),
	@NamedQuery(name="Libro.findById", query="SELECT l FROM Libro l WHERE l.identificador = :identificador"),
	@NamedQuery(name="Libro.findByISBN", query="SELECT l FROM Libro l WHERE l.isbn = :isbn"),
	@NamedQuery(name="Libro.findByTitulo", query="SELECT l FROM Libro l WHERE l.titulo = :titulo"),
	@NamedQuery(name="Libro.findByAutor", query="SELECT l FROM Libro l INNER JOIN LibroAutor a ON l.cdlibro = a.libro.cdlibro WHERE a.autor.identificador = :identificadorAutor "),
})

public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cdlibro")
	private String identificador;

	@Column(name="cdcolecc")
	private String identificadorColeccion;

	@Column(name="cdeditor")
	private String identificadorEditor;

	@Column(name="dslibro")
	private String titulo;

	@Lob
	@Column(name="dsresena")
	private String resenia;

	@Column(name="dssku")
	private String isbn;

	@Column(name="escompra")
	private String esComprado;

	@Column(name="feadquis")
	@Temporal(TemporalType.DATE)
	private Date fechaAdquisicion;

	@Column(name="nuanioed")
	private int anioEdicion;

	@Column(name="nuedicio")
	private int edicion;

	@XmlTransient
	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//bi-directional many-to-one association to LibroAutor
	@OneToMany(mappedBy="libro")
	private List<LibroAutor> libroAutors;

	//bi-directional many-to-one association to LibroClasificacion
	@OneToMany(mappedBy="libro")
	private List<LibroClasificacion> libroClasificacions;

	public Libro() {
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getIdentificadorColeccion() {
		return identificadorColeccion;
	}

	public void setIdentificadorColeccion(String identificadorColeccion) {
		this.identificadorColeccion = identificadorColeccion;
	}

	public String getIdentificadorEditor() {
		return identificadorEditor;
	}

	public void setIdentificadorEditor(String identificadorEditor) {
		this.identificadorEditor = identificadorEditor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResenia() {
		return resenia;
	}

	public void setResenia(String resenia) {
		this.resenia = resenia;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEsComprado() {
		return esComprado;
	}

	public void setEsComprado(String esComprado) {
		this.esComprado = esComprado;
	}

	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	public int getAnioEdicion() {
		return anioEdicion;
	}

	public void setAnioEdicion(int anioEdicion) {
		this.anioEdicion = anioEdicion;
	}

	public int getEdicion() {
		return edicion;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

	public List<LibroAutor> getLibroAutors() {
		return this.libroAutors;
	}

	public void setLibroAutors(List<LibroAutor> libroAutors) {
		this.libroAutors = libroAutors;
	}

	public LibroAutor addLibroAutor(LibroAutor libroAutor) {
		getLibroAutors().add(libroAutor);
		libroAutor.setLibro(this);

		return libroAutor;
	}

	public LibroAutor removeLibroAutor(LibroAutor libroAutor) {
		getLibroAutors().remove(libroAutor);
		libroAutor.setLibro(null);

		return libroAutor;
	}

	public List<LibroClasificacion> getLibroClasificacions() {
		return this.libroClasificacions;
	}

	public void setLibroClasificacions(List<LibroClasificacion> libroClasificacions) {
		this.libroClasificacions = libroClasificacions;
	}

	public LibroClasificacion addLibroClasificacion(LibroClasificacion libroClasificacion) {
		getLibroClasificacions().add(libroClasificacion);
		libroClasificacion.setLibro(this);

		return libroClasificacion;
	}

	public LibroClasificacion removeLibroClasificacion(LibroClasificacion libroClasificacion) {
		getLibroClasificacions().remove(libroClasificacion);
		libroClasificacion.setLibro(null);

		return libroClasificacion;
	}

}