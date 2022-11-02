package io.github.brunoyillli.brunopay.modelo;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "TRANSACOES")
public class Transacao extends EntidadeBase {

	@Column(name = "TR_CODIGO", nullable = false)
	private String codigo;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@Column(name = "TR_USUARIO_ORIGEM", nullable = false)
	private Usuario origem;

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
	@Column(name = "TR_USUARIO_DESTINO", nullable = false)
	private Usuario destino;

	@Column(name = "TR_DATA_HORA", nullable = false)
	private LocalDateTime dataHora;

	@Column(name = "TR_VALOR", nullable = false)
	private Double valor;
}
