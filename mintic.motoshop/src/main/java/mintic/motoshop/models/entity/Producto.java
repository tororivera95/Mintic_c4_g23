package mintic.motoshop.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Producto")
public class Producto implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(length = 50, nullable=false)
	private String nombre;
	
	@Column(length = 50, nullable=false)
	private String marca;
	
	@Column(length = 50, nullable=false)
	private String cilindraje;
	
	@Column(length = 50, nullable=false)
	private String tipo;
	
	@Column(length = 50, nullable=false)
	private String semiauto;
	
	@Column(length = 50, nullable=false)
	private String torque;
	
	@Column(length = 50, nullable=false)
	private String velocidad;

	
	//Get and Set
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSemiauto() {
		return semiauto;
	}

	public void setSemiauto(String semiauto) {
		this.semiauto = semiauto;
	}

	public String getTorque() {
		return torque;
	}

	public void setTorque(String torque) {
		this.torque = torque;
	}

	public String getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}