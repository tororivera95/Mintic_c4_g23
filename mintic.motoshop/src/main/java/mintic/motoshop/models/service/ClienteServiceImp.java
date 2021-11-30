package mintic.motoshop.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mintic.motoshop.models.dao.IClienteDao;
import mintic.motoshop.models.entity.Cliente;

@Service
public class ClienteServiceImp implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() { //Obtenemos todos los clientes de la base de datos
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findById(Long Id) { //Se obtiene un cliente mediante su ID
		return clienteDao.findById(Id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) { //Se guarda un cliente
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Cliente cliente) { //Se borra un cliente
		clienteDao.delete(cliente);
	}
}
