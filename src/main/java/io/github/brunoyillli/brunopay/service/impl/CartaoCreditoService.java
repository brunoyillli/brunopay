package io.github.brunoyillli.brunopay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.brunoyillli.brunopay.conversor.CartaoCreditoConversor;
import io.github.brunoyillli.brunopay.dto.CartaoCreditoDTO;
import io.github.brunoyillli.brunopay.modelo.CartaoCredito;
import io.github.brunoyillli.brunopay.repository.CartaoCreditoRepository;
import io.github.brunoyillli.brunopay.service.ICartaoCreditoService;
import io.github.brunoyillli.brunopay.service.IUsuarioService;

@Service
public class CartaoCreditoService implements ICartaoCreditoService {

	@Autowired
	private CartaoCreditoRepository cartaoCreditoRepository;

	@Autowired
	private CartaoCreditoConversor cartaoCreditoConversor;

	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public CartaoCreditoDTO salvar(CartaoCreditoDTO cartaoCreditoDTO) {
		CartaoCreditoDTO cartaoCreditoRetorno = null;
		if (cartaoCreditoDTO.getIsSalva()) {
			CartaoCredito cartaoCredito = cartaoCreditoConversor.converterDtoParaEntidade(cartaoCreditoDTO);
			usuarioService.validar(cartaoCredito.getUsuario());
			CartaoCredito cartaoCreditoSalvo = cartaoCreditoRepository.save(cartaoCredito);
			cartaoCreditoRetorno = cartaoCreditoConversor.converterEntidadeParaDto(cartaoCreditoSalvo);
		}
		return cartaoCreditoRetorno;
	}

}
