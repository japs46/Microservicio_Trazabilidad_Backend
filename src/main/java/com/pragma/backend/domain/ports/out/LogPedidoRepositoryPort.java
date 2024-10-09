package com.pragma.backend.domain.ports.out;

import java.util.List;

import com.pragma.backend.domain.models.LogPedido;

public interface LogPedidoRepositoryPort {

	public LogPedido guardarLog(LogPedido log);
	
    public List<LogPedido> consultarLogsPorPedido(Long pedidoId);
}
