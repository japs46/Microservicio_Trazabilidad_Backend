package com.pragma.backend.infrastructure.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "logs_pedido")
public class LogPedidoEntity {


	@Id
	private String id;
	
	private Long pedidoId;
	private Long clienteId;
	private String estadoAnterior;
	private String estadoNuevo;
	private LocalDateTime fechaCambio;

	public LogPedidoEntity(String id, Long pedidoId, Long clienteId, String estadoAnterior, String estadoNuevo,
			LocalDateTime fechaCambio) {
		this.id = id;
		this.pedidoId = pedidoId;
		this.clienteId = clienteId;
		this.estadoAnterior = estadoAnterior;
		this.estadoNuevo = estadoNuevo;
		this.fechaCambio = fechaCambio;
	}

	public String getId() {
		return id;
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

}
