package adapter;

import br.com.db1.db1start.bancoapi.entity.Estado;
import dto.EstadoDTO;

public class EstadoAdapter {
	
	public static EstadoDTO transformarEntidadeParaDTO(Estado estado) {
		EstadoDTO dto = new EstadoDTO();
		
		dto.setNome(estado.getNome());
		dto.setId(estado.getId());
		
		return dto;
		
	}

}
