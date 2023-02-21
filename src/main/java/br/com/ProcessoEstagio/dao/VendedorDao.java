package br.com.ProcessoEstagio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.ProcessoEstagio.models.Vendedor;

public interface VendedorDao extends CrudRepository<Vendedor, String> {
	
	Vendedor findByCpfCnpj(String cpfCnpj);
	
	List<Vendedor> findByNome(String nome);
}