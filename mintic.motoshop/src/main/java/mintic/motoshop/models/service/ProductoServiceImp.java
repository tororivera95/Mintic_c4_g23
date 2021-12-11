package mintic.motoshop.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import mintic.motoshop.models.dao.IProductoDao;
import mintic.motoshop.models.entity.Producto;

public class ProductoServiceImp implements IProductoService{

	@Autowired
	private IProductoDao productoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findById(Long Id) {
		return productoDao.findById(Id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	@Transactional
	public void delete(Producto producto) {
		productoDao.delete(producto);
		
	}

}
