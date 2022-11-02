package io.github.brunoyillli.brunopay.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.brunoyillli.brunopay.exceptions.NegocioException;
import io.github.brunoyillli.brunopay.modelo.Transacao;
import io.github.brunoyillli.brunopay.modelo.Usuario;
import io.github.brunoyillli.brunopay.repository.UsuarioRepository;
import io.github.brunoyillli.brunopay.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario consultarEntidade(String login) {
		return usuarioRepository.findByLogin(login);
	}

	@Override
	public void validar(Usuario... usuarios) {
		Arrays.asList(usuarios).stream().forEach(usuario -> {
			if(usuario == null) {
				throw new NegocioException("O usuario informado nao existe!");
			}
		});
		
	}

	@Override
	public void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito) {
		// TODO Auto-generated method stub
		
	}

}
