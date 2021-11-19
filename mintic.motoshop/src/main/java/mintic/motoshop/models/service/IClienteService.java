package mintic.motoshop.models.service;

import java.util.List;

import mintic.motoshop.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findById(Long Id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Cliente cliente);
}
