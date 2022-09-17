package com.algaworks.algalog.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import com.algaworks.algalog.domain.ValidationGroups;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Cliente {

	// Criamos um grupo de validação diferente do Default para dizer para outras validações externas que não é
	// possível referenciar um cliente sem passar o Id, se não fizermos isso, ele ficará com o grupo Default
	// e até os endpoints de clientes irá ser obrigátorio passar o id (O que não faz sentido, já que é autoincrementavel);
	// PS: Os @Valid nos endpoints das classes controllers usam como padrão os groups = Default.class;
	@NotNull(groups = ValidationGroups.ClienteId.class) 
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(groups = Default.class) // (groups = ...) Apenas para representar que todas as anotações de validações possuem esse grupo naturalmente;
	@Size(max = 60)
	private String nome;
	
	@NotBlank
	@Email
	@Size(max = 255)
	private String email;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "fone")
	private String telefone;
	
}
