package br.com.lojacamisetas.projetojavaloja.classe;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nome;
	String cpf;
	//@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	//List<Venda> vendas;
	
	@ElementCollection
    @CollectionTable(name = "venda_ids", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "venda_id")
	private List<Long> vendaIds = new ArrayList<>();
}
