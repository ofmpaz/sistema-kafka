package br.com.kafka.sistema_kafka.producer.repository;

import br.com.kafka.sistema_kafka.producer.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
