package com.pragma.backend.infrastructure.adapters;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pragma.backend.domain.models.LogPedido;
import com.pragma.backend.domain.ports.out.LogPedidoRepositoryPort;
import com.pragma.backend.infrastructure.entities.LogPedidoEntity;
import com.pragma.backend.infrastructure.mappers.LogPedidoMapper;

@Repository
public class LogPedidoAdapter implements LogPedidoRepositoryPort{
	
	private final LogPedidoEntityRepository logPedidoEntityRepository;
	
	public LogPedidoAdapter(LogPedidoEntityRepository logPedidoEntityRepository) {
		this.logPedidoEntityRepository = logPedidoEntityRepository;
	}

	@Override
	public LogPedido guardarLog(LogPedido logPedido) {
		LogPedidoEntity logPedidoEntity = LogPedidoMapper.toEntity(logPedido);

		return LogPedidoMapper.toDomain(logPedidoEntityRepository.save(logPedidoEntity));
	}

	@Override
	public List<LogPedido> consultarLogsPorPedido(Long pedidoId) {
		return logPedidoEntityRepository.findByPedidoId(pedidoId).stream()
				.map(LogPedidoMapper::toDomain).toList();
	}

}
