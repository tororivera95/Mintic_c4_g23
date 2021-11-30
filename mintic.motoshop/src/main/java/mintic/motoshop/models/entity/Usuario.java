package mintic.motoshop.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "username", unique=true, length=20)
	private String username;

	@Column(name = "password", length=60)
	private String password;
	
	private boolean enabled;
 
	@Column(name="nom_usuario")
	private String nombre;

	@Column(name="apell_usuario")
	private String apellido;

	@Column(name="email_usuario",unique=true)
	private String email;

	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="usuario_roles", joinColumns=@JoinColumn(name="usuario_id"), 
	inverseJoinColumns=@JoinColumn(name="roles_id"), 
	uniqueConstraints= {@UniqueConstraint(columnNames= {"usuario_id","roles_id"})})
	private List<Roles> roles;

	// Constructor
	public Usuario() {

	}

	public Usuario(Long id, String username, String password, boolean enabled, String nombre, String apellido,
			String email, List<Roles> roles) {
		Id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.roles = roles;
	}

	// Get and Set
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	/**
	 *
	**/
	private static final long serialVersionUID = 1L;
}
