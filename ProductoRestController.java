package mintic.motoshop.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import mintic.motoshop.models.entity.Producto;
import mintic.motoshop.models.service.IProductoService;

@CrossOrigin(origins= {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class ProductoRestController{
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/productos") //Obtenemos todos los productos registrados en la BD
	public List<Producto> index(){ 
		return productoService.findAll();	 
	}
	
	@GetMapping("/producto/{Id}") //Obtenemos los productos mediante el ID
	public Producto show(@PathVariable Long Id) {
		return productoService.findById(Id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/productos") //Se crean los producto
	public ResponseEntity<?> create(@Valid @RequestBody Producto producto, BindingResult result) {
		
		Producto productoNew = null; 
		
		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err-> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);	
		}
		
		try {
			productoNew = this.productoService.save(producto);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert a la base de datos");
			response.put("error ", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("Mensaje", "El producto ha sido creado con éxito!");
		response.put("Cliente", productoNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}

	@Secured({"ROLE_ADMIN"})
	@PutMapping("/producto/{Id}") //Actualizamos los datos mediante los ID
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@Valid @RequestBody Producto producto, @PathVariable Long Id, BindingResult result) {
		
		
		Producto currentProducto = this.productoService.findById(Id);
		Producto productoUpdate = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err-> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(currentProducto == null) {
			response.put("mensaje", "Error: No se puede editar el producto ID: ".concat(Id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			currentProducto.setNombre(producto.getNombre());
			currentProducto.setMarca(producto.getMarca());
			currentProducto.setCilindraje(producto.getCilindraje());
			currentProducto.setTipo(producto.getTipo());
			currentProducto.setSemiauto(producto.getSemiauto());
			currentProducto.setTipo(producto.getTipo());
			currentProducto.setTorque(producto.getTorque());
			currentProducto.setVelocidad(producto.getVelocidad());
			this.productoService.save(currentProducto);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el producto");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("Mensaje", "El producto ha sido actualizado con éxito!");
		response.put("Producto", productoUpdate);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/productos/{Id}") //Eliminamos el producto mediante el ID
	public ResponseEntity<?> delete(@PathVariable Long Id){
		
		Map<String, Object> response = new HashMap<>();
		
		try{
			
			Producto producto = this.productoService.findById(Id);
			this.productoService.delete(producto);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje", "El producto eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
