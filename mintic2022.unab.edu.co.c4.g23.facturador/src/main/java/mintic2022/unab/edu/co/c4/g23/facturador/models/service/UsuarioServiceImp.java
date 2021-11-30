package mintic2022.unab.edu.co.c4.g23.facturador.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mintic2022.unab.edu.co.c4.g23.facturador.models.dao.IUsuarioDao;
import mintic2022.unab.edu.co.c4.g23.facturador.models.entity.Usuario;

@Service
public class UsuarioServiceImp implements IUsuarioService, UserDetailsService { //Clase que sirve para traer los datos del usuario de la BD

	private Logger logger = LoggerFactory.getLogger(UsuarioServiceImp.class); //Logger sirve para mostrar los errores
	
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioDao.findByUsername(username);//Buscamos el usuario
		
		if(usuario == null) { //Se valida que el usuario exista
			logger.error("Error en el login: no existe el usuario: '"+ username +"' en el sistema");
			throw new UsernameNotFoundException("Error en el login:  no existe el usuario: '"+ username +"' en el sistema");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles() //Nos devuelve todos los roles que tiene el usuario
				.stream()
				.map(role-> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority->logger.info("Role :" + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(), true, true, true, authorities);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}
}
