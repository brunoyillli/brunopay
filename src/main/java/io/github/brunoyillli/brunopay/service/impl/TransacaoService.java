package io.github.brunoyillli.brunopay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.brunoyillli.brunopay.conversor.TransacaoConversor;
import io.github.brunoyillli.brunopay.dto.TransacaoDTO;
import io.github.brunoyillli.brunopay.modelo.Transacao;
import io.github.brunoyillli.brunopay.repository.TransacaoRepository;
import io.github.brunoyillli.brunopay.service.ICartaoCreditoService;
import io.github.brunoyillli.brunopay.service.ITransacoaoService;
import io.github.brunoyillli.brunopay.service.IUsuarioService;

@Service
public class TransacaoService implements ITransacoaoService {
	
	@Autowired
	private TransacaoConversor transacaoConversor;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	private ICartaoCreditoService cartaoCreditoService;
	
	@Override
	public TransacaoDTO processar(TransacaoDTO transacaoDTO) {
		Transacao transacao = salvar(transacaoDTO);
		cartaoCreditoService.salvar(transacaoDTO.getCartaoCredito());
		usuarioService.atualizarSaldo(transacao, transacaoDTO.getIsCartaoCredito());
		return transacaoConversor.converterEntidadeParaDto(transacao);
	}

	private Transacao salvar(TransacaoDTO transacaoDTO) {
		Transacao transacao = transacaoConversor.converterDtoParaEntidade(transacaoDTO);
		usuarioService.validar(transacao.getDestino(), transacao.getOrigem());
		return transacaoRepository.save(transacao);
	}
	
}
