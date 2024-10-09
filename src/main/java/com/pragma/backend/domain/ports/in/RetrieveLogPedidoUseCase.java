package com.pragma.backend.domain.ports.in;

import java.util.List;

import com.pragma.backend.domain.models.LogPedido;

public interface RetrieveLogPedidoUseCase {

	public List<LogPedido> obtenerPorPedido(Long pedidoId, Long clienteId);
}
