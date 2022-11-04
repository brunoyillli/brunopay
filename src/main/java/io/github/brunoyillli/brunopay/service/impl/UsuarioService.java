package io.github.brunoyillli.brunopay.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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
			if (usuario == null) {
				throw new NegocioException("O usuario informado nao existe!");
			}
		});

	}

	@Override
	@Async("asyncExecutor")
	public void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito) {
		decrementarSaldo(transacao, isCartaoCredito);
		incrementarSaldo(transacao);
	}

	private void incrementarSaldo(Transacao transacao) {
		usuarioRepository.updateIncrementarSaldo(transacao.getDestino().getLogin(), transacao.getValor());

	}

	private void decrementarSaldo(Transacao transacao, Boolean isCartaoCredito) {
		if (!isCartaoCredito) {
			usuarioRepository.updateDecrementarSaldo(transacao.getOrigem().getLogin(), transacao.getValor());
		}
	}

}
