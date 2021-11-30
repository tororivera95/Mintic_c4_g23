package mintic2022.unab.edu.co.c4.g23.facturador.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Cliente")
	private Long Id;
	
	@NotEmpty(message="No puede estar vacio")
	@Size(min=4,max=20, message="El tamaño tiene que estar entre 4 y 20 caracteres")
	@Column(name = "nom_Cliente", nullable=false)
	private String nombre;
	
	@Column(name = "apelli_Cliente", nullable=false)
	private String apellido;
	
	@NotEmpty(message="No puede estar vacio")
	@Email(message="No es una direccion de correo electronica valida")
	@Column(name = "email_Cliente", nullable=false, unique=true)
	private String email;
	
	@Column(name = "direc_Cliente")
	private String direccion;

	@NotNull(message="No puede estar vacio")
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@NotNull(message="La region no puede estar vacia")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="region_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Region region;
	
	//Constructor
	public Cliente() {
		
	}

	public Cliente(Long id, String nombre, String apellido, String email, String direccion, Date createAt) {
		Id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.direccion = direccion;
		this.createAt = createAt;
	}

	//Get and Set
	public Long getId() {
		return Id;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFullName() {
			return this.nombre + " " + this.apellido;
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
