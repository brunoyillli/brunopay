package io.github.brunoyillli.brunopay.modelo;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class EntidadeBase {
	
	private Long id;
}
