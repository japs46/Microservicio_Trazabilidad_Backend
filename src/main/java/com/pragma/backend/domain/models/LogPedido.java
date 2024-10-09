package com.pragma.backend.domain.models;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class LogPedido {

	private String id;
	
	@NotNull(message = "El ID del pedido no puede ser null")
	@Min(value = 1, message = "El ID del pedido debe ser un numero positivo")
	private Long pedidoId;
	
	@NotNull(message = "El ID del cliente no puede ser null")
	@Min(value = 1, message = "El ID del cliente debe ser un numero positivo")
	private Long clienteId;
	
	@NotEmpty(message = "El estado anterior no puede ser null")
	private String estadoAnterior;
	
	@NotEmpty(message = "El estado nuevo no puede ser null")
	private String estadoNuevo;
	
	@NotNull(message = "La fecha no puede ser null")
	private LocalDateTime fechaCambio;

	public LogPedido(String id, Long pedidoId, Long clienteId, String estadoAnterior, String estadoNuevo,
			LocalDateTime fechaCambio) {
		this.id = id;
		this.pedidoId = pedidoId;
		this.clienteId = clienteId;
		this.estadoAnterior = estadoAnterior;
		this.estadoNuevo = estadoNuevo;
		this.fechaCambio = fechaCambio;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public String getEstadoAnterior() {
		return estadoAnterior;
	}

	public String getEstadoNuevo() {
		return estadoNuevo;
	}

	public LocalDateTime getFechaCambio() {
		return fechaCambio;
	}

	public String getId() {
		return id;
	}

}
