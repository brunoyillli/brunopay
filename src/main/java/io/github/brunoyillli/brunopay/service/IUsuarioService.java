package io.github.brunoyillli.brunopay.service;

import java.util.List;

import io.github.brunoyillli.brunopay.dto.UsuarioDTO;
import io.github.brunoyillli.brunopay.modelo.Transacao;
import io.github.brunoyillli.brunopay.modelo.Usuario;

public interface IUsuarioService {

	Usuario consultarEntidade(String login);

	void validar(Usuario... usuarios);

	void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito);

	UsuarioDTO consultar(String login);

	List<UsuarioDTO> listar(String login);

}
