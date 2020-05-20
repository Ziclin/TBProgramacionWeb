package pe.progra.tb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Table(name="Pelicula")
public class Pelicula implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPelicula;
	
	@Column(name = "namePelicula", length = 100, nullable = false)
	private String namePelicula;
	
	@NotNull
	@Past(message = "La fecha debe estar en el pasado")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datePelicula")
	private Date datePelicula;
	
	@ManyToMany (mappedBy = "Actor_Pelicula")
	private List<Actor> Actores;
	
	@ManyToMany (mappedBy = "Lista_Pelicula")
	private List<Lista> Listas;
	
	@OneToMany(mappedBy = "pelicula")
	private List<ResenaPelicula> peliculas;
	
	
	
	public List<Lista> getListas() {
		return Listas;
	}


	public void setListas(List<Lista> listas) {
		Listas = listas;
	}


	public List<ResenaPelicula> getPeliculas() {
		return peliculas;
	}


	public void setPeliculas(List<ResenaPelicula> peliculas) {
		this.peliculas = peliculas;
	}


	public int getIdPelicula() {
		return idPelicula;
	}


	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}


	public String getNamePelicula() {
		return namePelicula;
	}


	public void setNamePelicula(String namePelicula) {
		this.namePelicula = namePelicula;
	}


	public Date getDatePelicula() {
		return datePelicula;
	}


	public void setDatePelicula(Date datePelicula) {
		this.datePelicula = datePelicula;
	}


	public List<Actor> getActores() {
		return Actores;
	}


	public void setActores(List<Actor> actores) {
		Actores = actores;
	}
	
	
	

	
	public Pelicula(int idPelicula, String namePelicula,Date datePelicula, List<Actor> actores, List<Lista> listas, List<ResenaPelicula> peliculas) {
		super();
		this.idPelicula = idPelicula;
		this.namePelicula = namePelicula;
		this.datePelicula = datePelicula;
		Actores = actores;
		Listas = listas;
		this.peliculas = peliculas;
	}


	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPelicula;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		if (idPelicula != other.idPelicula)
			return false;
		return true;
	}


	
}





