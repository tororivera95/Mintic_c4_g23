package mintic.motoshop.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import mintic.motoshop.models.entity.Producto;

@Repository
public interface IProductoDao extends CrudRepository<Producto,Long>{

}
