package mintic.motoshop.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import mintic.motoshop.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username); //Se realiza la busqueda del usuario mediante el Username

	@Query("select u from Usuario u where u.username=?1")
	public Usuario findByUsername2(String username); //Se realiza la busqueda del usuario directamente a la BD

}
