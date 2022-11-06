package io.github.brunoyillli.brunopay.resource.swagger;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import io.github.brunoyillli.brunopay.dto.ErrorDTO;
import io.github.brunoyillli.brunopay.dto.TransacaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Transacao", description = "Operacao relacionadas a Transacao")
public interface ITransacaoResource {

	@Operation(summary = "Salvar uma transacao")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Transacao realizada com sucesso", content = @Content(schema = @Schema(implementation = TransacaoDTO.class))),
			@ApiResponse(responseCode = "400", description = "Dados informados para a requisição estão inconsistentes", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
			@ApiResponse(responseCode = "401", description = "Usuário sem permissão para acessar o recurso", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
    		@ApiResponse(responseCode = "404", description = "Nao foi possivel realizar a transacao", content = @Content(schema = @Schema(implementation = ErrorDTO.class))) })
	public ResponseEntity<TransacaoDTO> salvar(@RequestBody @Valid TransacaoDTO transacaoDTO,
			UriComponentsBuilder uriBuilder);
	
	@Operation(summary = "Listar as transacoes de um usuario")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Transacoes escontradas com sucesso", content = @Content(schema = @Schema(implementation = TransacaoDTO.class))),
			@ApiResponse(responseCode = "400", description = "Dados informados para a requisição estão inconsistentes", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
			@ApiResponse(responseCode = "401", description = "Usuário sem permissão para acessar o recurso", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
    		@ApiResponse(responseCode = "404", description = "Transacoes nao encontradas", content = @Content(schema = @Schema(implementation = ErrorDTO.class))) })
	public ResponseEntity<Page<TransacaoDTO>> listar(@PageableDefault(page = 0, size = 20) Pageable paginacao, 
			@RequestParam String login);
}
