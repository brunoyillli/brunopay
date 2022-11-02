package io.github.brunoyillli.brunopay.service;

import io.github.brunoyillli.brunopay.modelo.Transacao;
import io.github.brunoyillli.brunopay.modelo.Usuario;

public interface IUsuarioService {

	Usuario consultarEntidade(String login);

	void validar(Usuario... usuarios);

	void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito);

}
