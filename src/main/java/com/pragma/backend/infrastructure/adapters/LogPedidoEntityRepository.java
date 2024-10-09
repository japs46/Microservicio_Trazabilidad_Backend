package com.pragma.backend.infrastructure.adapters;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pragma.backend.infrastructure.entities.LogPedidoEntity;

public interface LogPedidoEntityRepository extends MongoRepository<LogPedidoEntity, String>{

	List<LogPedidoEntity> findByPedidoId(Long pedidoId);
}
