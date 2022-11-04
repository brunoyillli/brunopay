package io.github.brunoyillli.brunopay.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.brunoyillli.brunopay.dto.UsuarioDTO;
import io.github.brunoyillli.brunopay.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource extends ResourceBase<UsuarioDTO> {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/{login}")
	public ResponseEntity<UsuarioDTO> consultar(@PathVariable String login) {
		UsuarioDTO usuario = usuarioService.consultar(login);
		return responderSucessoComItem(usuario);
	}

	@GetMapping("/contatos")
	public ResponseEntity<List<UsuarioDTO>> listar(@RequestParam String login) {
		List<UsuarioDTO> usuarios = usuarioService.listar(login);
		return responderListaDeItens(usuarios);
	}

	@GetMapping("/{login}/saldo")
	public ResponseEntity<UsuarioDTO> consultarSaldo(@PathVariable String login) {
		UsuarioDTO usuarioDTO = usuarioService.consultar(login);
		return responderSucessoComItem(usuarioDTO);
	}
}
