package mintic.motoshop.models.service;

import java.util.List;
import mintic.motoshop.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();

	public Producto findById(Long Id);

	public Producto save(Producto producto);

	public void delete(Producto producto);
}
