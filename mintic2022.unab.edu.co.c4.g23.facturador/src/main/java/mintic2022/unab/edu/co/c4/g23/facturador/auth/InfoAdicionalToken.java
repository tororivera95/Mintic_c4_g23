package mintic2022.unab.edu.co.c4.g23.facturador.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import mintic2022.unab.edu.co.c4.g23.facturador.models.entity.Usuario;
import mintic2022.unab.edu.co.c4.g23.facturador.models.service.IUsuarioService;

@Component
public class InfoAdicionalToken implements TokenEnhancer{ //Clase que sirve para conectar a la BD y traer los datos del usuario al momento de logiarse

	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Map<String,Object> info = new HashMap<>();
		info.put("info adicional ", "Hola que tal : ".concat(authentication.getName()));
		
		info.put("nombre ", usuario.getNombre());
		info.put("apellido ", usuario.getApellido());
		info.put("email ", usuario.getEmail());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}
}
