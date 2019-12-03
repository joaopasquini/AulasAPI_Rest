package br.com.db1.db1start.bancoapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import adapter.EstadoAdapter;
import br.com.db1.db1start.bancoapi.entity.Estado;
import br.com.db1.db1start.bancoapi.service.EstadoService;
import dto.EstadoDTO;
import dto.EstadoFormDTO;


@RestController
public class EstadoController {
    
	@Autowired
    private EstadoService estadoService;
	
	@GetMapping("/estados")
    public List<EstadoDTO> buscarTodosEstados() {
        List<Estado> estados = estadoService.buscarTodos();
        List<EstadoDTO> listaDeRetorno = new ArrayList();

        estados.forEach(estado -> {
            EstadoDTO meuEstadoDto = EstadoAdapter.transformarEntidadeParaDTO(estado);
            listaDeRetorno.add(meuEstadoDto);
        });

        return listaDeRetorno;
    }
	
	@PostMapping("/estados")
	public void cadastrarNovoEstado(@RequestBody EstadoFormDTO formDto) {
		estadoService.criar(formDto.getNome());
	}
	
	@PutMapping("/estados/(estadoId)")
	public void atualizaEstado(@PathVariable Long estadoId, @RequestBody EstadoFormDTO form) {
		estadoService.atualizar(estadoId, form);
	}
	
	@DeleteMapping("/estados/(estadoId)")
	public void deletaEstado(@PathVariable Long estadoId) {
		estadoService.deletarPorId(estadoId);
	}
	
}
