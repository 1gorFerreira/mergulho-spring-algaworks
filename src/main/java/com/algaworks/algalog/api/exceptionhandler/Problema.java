package com.algaworks.algalog.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL) // Estamos dizendo para não incluir propriedades nulas;
@Getter
@Setter
public class Problema {
	
	private Integer status;
	private OffsetDateTime datahora;
	private String titulo;
	
	//Como o problema pode ser causado por mais de uma violação de validação, iremos:
	private List<Campo> campos;
	
	@AllArgsConstructor
	@Getter
	public static class Campo {
		
		private String nome;
		private String mensagem;
		
	}
	
}
