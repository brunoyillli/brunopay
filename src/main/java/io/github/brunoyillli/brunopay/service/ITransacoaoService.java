package io.github.brunoyillli.brunopay.service;

import javax.validation.Valid;

import io.github.brunoyillli.brunopay.dto.TransacaoDTO;

public interface ITransacoaoService {

	TransacaoDTO processar(TransacaoDTO transacaoDTO);

}
