package io.github.brunoyillli.brunopay.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.brunoyillli.brunopay.dto.CartaoCreditoDTO;
import io.github.brunoyillli.brunopay.modelo.CartaoCredito;
import io.github.brunoyillli.brunopay.service.IUsuarioService;
import io.github.brunoyillli.brunopay.util.CartaoCreditoUtil;

@Component
public class CartaoCreditoConversor extends ConversorBase<CartaoCredito, CartaoCreditoDTO> {

	@Autowired
	IUsuarioService usuarioService;

	@Override
	public CartaoCreditoDTO converterEntidadeParaDto(CartaoCredito entidade) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<CartaoCredito, CartaoCreditoDTO>() {
			@Override
			protected void configure() {
			}
		});
		return modelMapper.map(entidade, CartaoCreditoDTO.class);
	}

	@Override
	public CartaoCredito converterDtoParaEntidade(CartaoCreditoDTO dto) {
		return CartaoCredito.builder().bandeira(dto.getBandeira()).numero(CartaoCreditoUtil.mascarar(dto.getNumero()))
				.numeroToken(dto.getNumeroToken())
				.usuario(usuarioService.consultarEntidade(dto.getUsuario().getLogin())).build();

	}

}
