package com.pragma.backend.domain.ports.in;

import com.pragma.backend.domain.models.LogPedido;

public interface CreateLogPedidoUseCase {

	public LogPedido createLog(LogPedido logPedido);
	
}
