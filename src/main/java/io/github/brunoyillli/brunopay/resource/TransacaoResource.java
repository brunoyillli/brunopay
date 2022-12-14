package io.github.brunoyillli.brunopay.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.github.brunoyillli.brunopay.dto.TransacaoDTO;
import io.github.brunoyillli.brunopay.resource.swagger.ITransacaoResource;
import io.github.brunoyillli.brunopay.service.ITransacoaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoResource extends ResourceBase<TransacaoDTO> implements ITransacaoResource {

	@Autowired
	private ITransacoaoService transacaoService;

	@PostMapping
	public ResponseEntity<TransacaoDTO> salvar(@RequestBody @Valid TransacaoDTO transacaoDTO,
			UriComponentsBuilder uriBuilder) {
		TransacaoDTO transacaoRetornoDTO = transacaoService.processar(transacaoDTO);
		return responderItemCriadoComURI(transacaoRetornoDTO, uriBuilder, "/transacoes/{codigo}",
				transacaoRetornoDTO.getCodigo());
	}
	
	@GetMapping
	public ResponseEntity<Page<TransacaoDTO>> listar(@PageableDefault(page = 0, size = 20) Pageable paginacao, 
			@RequestParam String login){
		Page<TransacaoDTO> trasacoes = transacaoService.listar(paginacao, login);
		return responderListaDeItensPaginada(trasacoes);
	}
}
