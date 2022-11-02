package io.github.brunoyillli.brunopay.service;

import io.github.brunoyillli.brunopay.dto.CartaoCreditoDTO;
import io.github.brunoyillli.brunopay.modelo.CartaoCredito;

public interface ICartaoCreditoService {

	CartaoCredito salvar(CartaoCreditoDTO cartaoCredito);

}
