package io.github.brunoyillli.brunopay.service;

import io.github.brunoyillli.brunopay.dto.TransacaoDTO;

public interface ITransacoaoService {

	TransacaoDTO processar(TransacaoDTO transacaoDTO);

}
