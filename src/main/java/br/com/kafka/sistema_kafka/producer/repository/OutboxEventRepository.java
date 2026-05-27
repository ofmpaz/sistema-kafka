package br.com.kafka.sistema_kafka.producer.repository;

import br.com.kafka.sistema_kafka.producer.model.OutboxEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutboxEventRepository extends JpaRepository<OutboxEventEntity, Long> {

     List<OutboxEventEntity> findByStatus(String status);
}
