package com.pragma.backend.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pragma.backend.domain.models.LogPedido;
import com.pragma.backend.domain.ports.in.CreateLogPedidoUseCase;
import com.pragma.backend.domain.ports.in.RetrieveLogPedidoUseCase;

@Service
public class LogPedidoService implements CreateLogPedidoUseCase,RetrieveLogPedidoUseCase{

	private final CreateLogPedidoUseCase createLogPedidoUseCase;
	
	private final RetrieveLogPedidoUseCase retrieveLogPedidoUseCase;
	
	public LogPedidoService(CreateLogPedidoUseCase createLogPedidoUseCase,
			RetrieveLogPedidoUseCase retrieveLogPedidoUseCase) {
		this.createLogPedidoUseCase = createLogPedidoUseCase;
		this.retrieveLogPedidoUseCase = retrieveLogPedidoUseCase;
	}

	@Override
	public LogPedido createLog(LogPedido logPedido) {
		return createLogPedidoUseCase.createLog(logPedido);
	}

	@Override
	public List<LogPedido> obtenerPorPedido(Long pedidoId, Long clienteId) {
		return retrieveLogPedidoUseCase.obtenerPorPedido(pedidoId, clienteId);
	}

}
