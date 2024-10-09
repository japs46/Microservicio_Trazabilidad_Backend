package com.pragma.backend.infrastructure.mappers;

import com.pragma.backend.domain.models.LogPedido;
import com.pragma.backend.infrastructure.entities.LogPedidoEntity;

public class LogPedidoMapper {

	public static LogPedido toDomain(LogPedidoEntity entity) {
        return new LogPedido(entity.getId(),entity.getPedidoId(),entity.getClienteId(),
        		entity.getEstadoAnterior(),entity.getEstadoNuevo(),entity.getFechaCambio());
    }

    public static LogPedidoEntity toEntity(LogPedido domain) {
        return new LogPedidoEntity(domain.getId(),domain.getPedidoId(),domain.getClienteId(),
        		domain.getEstadoAnterior(),domain.getEstadoNuevo(),domain.getFechaCambio());
    }
    
}
