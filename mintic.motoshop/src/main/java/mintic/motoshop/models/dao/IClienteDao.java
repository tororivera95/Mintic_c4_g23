package mintic.motoshop.models.dao;

import org.springframework.data.repository.CrudRepository;

import mintic.motoshop.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long>{
	
}
