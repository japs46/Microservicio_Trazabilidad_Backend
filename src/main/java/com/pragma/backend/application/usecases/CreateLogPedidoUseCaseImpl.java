package com.pragma.backend.application.usecases;

import org.springframework.stereotype.Component;

import com.pragma.backend.domain.models.LogPedido;
import com.pragma.backend.domain.ports.in.CreateLogPedidoUseCase;
import com.pragma.backend.domain.ports.out.LogPedidoRepositoryPort;

@Component
public class CreateLogPedidoUseCaseImpl implements CreateLogPedidoUseCase{
	
	private final LogPedidoRepositoryPort logPedidoRepositoryPort;
	
	public CreateLogPedidoUseCaseImpl(LogPedidoRepositoryPort logPedidoRepositoryPort) {
		this.logPedidoRepositoryPort = logPedidoRepositoryPort;
	}

	@Override
	public LogPedido createLog(LogPedido logPedido) {
		return logPedidoRepositoryPort.guardarLog(logPedido);
	}

}
