package com.pragma.backend.infrastructure.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragma.backend.application.services.LogPedidoService;
import com.pragma.backend.domain.models.LogPedido;
import com.pragma.backend.infrastructure.providers.JwtTokenProvider;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/logs")
public class LogPedidoController {
	
	private Logger LOGGUER = LoggerFactory.getLogger(LogPedidoController.class);
	
	private final LogPedidoService logPedidoService;
	
	private final JwtTokenProvider jwtTokenProvider;

	public LogPedidoController(LogPedidoService logPedidoService,JwtTokenProvider jwtTokenProvider) {
		this.logPedidoService = logPedidoService;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@PostMapping("/guardar")
	public ResponseEntity<?> guardarLog(@RequestBody LogPedido logPedido){
		
		try {
			LOGGUER.info("Inicio Creacion de log");
			LogPedido logPedidoBd = logPedidoService.createLog(logPedido);

			return ResponseEntity.ok(logPedidoBd);
		} catch (Exception e) {
			LOGGUER.error("Ocurrio un inconveniente, descripcion del inconveniente: " + e.getMessage());
			return ResponseEntity.internalServerError().body("Ocurrio un inconveniente: " + e.getMessage());
		}
		
		
	}
	
	@GetMapping("/buscar/porPedido/{idPedido}")
	public ResponseEntity<?> buscarLogPedido(@PathVariable Long idPedido, HttpServletRequest request){
		try {
			LOGGUER.info("Inicio busqueda de log pedido");
			String authHeader = request.getHeader("Authorization");
			String token = null;
			if (authHeader != null && authHeader.startsWith("Bearer ")) {
				token = authHeader.substring(7);
			}
			Long idCliente = jwtTokenProvider.extractClaim(token, claims -> claims.get("idUser", Long.class));

			List<LogPedido> LogsPedido = logPedidoService.obtenerPorPedido(idPedido, idCliente);

			return ResponseEntity.ok(LogsPedido);
		} catch (Exception e) {
			LOGGUER.error("Ocurrio un inconveniente, descripcion del inconveniente: " + e.getMessage());
			return ResponseEntity.internalServerError().body("Ocurrio un inconveniente: " + e.getMessage());
		}
	}
}
