package io.github.brunoyillli.brunopay.resource.swagger;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.brunoyillli.brunopay.dto.ErrorDTO;
import io.github.brunoyillli.brunopay.dto.UsuarioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuario", description = "Operacao relacionadas a Usuarios")
public interface IUsuarioResource {

	@Operation(summary = "Consultar Usuario por Login")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso", content = @Content(schema = @Schema(implementation = UsuarioDTO.class))),
			@ApiResponse(responseCode = "400", description = "Dados informados para a requisição estão inconsistentes", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
			@ApiResponse(responseCode = "401", description = "Usuário sem permissão para acessar o recurso", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
    		@ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content(schema = @Schema(implementation = ErrorDTO.class))) })
	public ResponseEntity<UsuarioDTO> consultar(@PathVariable String login);

	@Operation(summary = "Consultar contatos de um usuário por login")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Contatos encontrado com sucesso", content = @Content(schema = @Schema(implementation = UsuarioDTO.class))),
			@ApiResponse(responseCode = "400", description = "Dados informados para a requisição estão inconsistentes", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
			@ApiResponse(responseCode = "401", description = "Usuário sem permissão para acessar o recurso", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
    		@ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content(schema = @Schema(implementation = ErrorDTO.class))) })
	public ResponseEntity<List<UsuarioDTO>> listar(@RequestParam String login);

	@Operation(summary = "Consultar saldo de um usuário por login")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Saldo consultado com sucesso", content = @Content(schema = @Schema(implementation = UsuarioDTO.class))),
			@ApiResponse(responseCode = "400", description = "Dados informados para a requisição estão inconsistentes", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
			@ApiResponse(responseCode = "401", description = "Usuário sem permissão para acessar o recurso", content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
    		@ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content(schema = @Schema(implementation = ErrorDTO.class))) })
	public ResponseEntity<UsuarioDTO> consultarSaldo(@PathVariable String login);
}
