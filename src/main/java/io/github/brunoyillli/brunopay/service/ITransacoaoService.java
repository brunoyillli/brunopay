package io.github.brunoyillli.brunopay.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.github.brunoyillli.brunopay.dto.TransacaoDTO;

public interface ITransacoaoService {

	TransacaoDTO processar(TransacaoDTO transacaoDTO);

	Page<TransacaoDTO> listar(Pageable paginacao, String login);

}
