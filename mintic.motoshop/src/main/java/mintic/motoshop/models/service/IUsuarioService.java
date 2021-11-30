package mintic.motoshop.models.service;

import mintic.motoshop.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);
	
}
