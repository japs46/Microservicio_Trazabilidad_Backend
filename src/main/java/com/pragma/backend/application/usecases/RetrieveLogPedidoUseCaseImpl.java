package com.pragma.backend.application.usecases;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pragma.backend.domain.models.LogPedido;
import com.pragma.backend.domain.ports.in.RetrieveLogPedidoUseCase;
import com.pragma.backend.domain.ports.out.LogPedidoRepositoryPort;

@Component
public class RetrieveLogPedidoUseCaseImpl implements RetrieveLogPedidoUseCase{
	
	private final LogPedidoRepositoryPort logPedidoRepositoryPort;
	
	public RetrieveLogPedidoUseCaseImpl(LogPedidoRepositoryPort logPedidoRepositoryPort) {
		this.logPedidoRepositoryPort = logPedidoRepositoryPort;
	}

	@Override
	public List<LogPedido> obtenerPorPedido(Long pedidoId, Long clienteId) {
		
		if (pedidoId == null) {
	        throw new IllegalArgumentException("El ID del pedido no puede ser nulo.");
	    }
	    
	    if (pedidoId<=0) {
	        throw new IllegalArgumentException("El ID del pedido debe ser un numero positivo.");
	    }
	    
	    List<LogPedido> logsPedido = logPedidoRepositoryPort.consultarLogsPorPedido(pedidoId);
	    
	    logsPedido.stream()
	    .filter(log -> log.getClienteId()!=clienteId)
	    .findAny()
	    .ifPresent(log -> {
	        throw new RuntimeException("Solo puedes consultar tus propios pedidos");
	    });
		
		return logsPedido;
	}

}
