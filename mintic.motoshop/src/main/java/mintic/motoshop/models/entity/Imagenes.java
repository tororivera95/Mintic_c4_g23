package mintic.motoshop.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Imagenes")
public class Imagenes implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Id_img")
	private long IdImg;
	
	@Column(nullable=false)
	@Lob
    private byte[] imagen;
	
	@Column(nullable=false)
	private boolean creado;

	//Get and Set
	public long getIdImg() {
		return IdImg;
	}

	public void setIdImg(long idImg) {
		IdImg = idImg;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public boolean getCreado() {
		return creado;
	}

	public void setCreado(boolean creado) {
		this.creado = creado;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

