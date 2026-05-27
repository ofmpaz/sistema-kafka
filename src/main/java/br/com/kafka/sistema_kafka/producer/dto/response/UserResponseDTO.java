package br.com.kafka.sistema_kafka.producer.dto.response;

import br.com.kafka.sistema_kafka.producer.model.UserEntity;

public record UserResponseDTO(
        Long id, String nome,
        String email) {

    public static UserResponseDTO fromEntity(UserEntity entity) {
        return new UserResponseDTO(entity.getId(), entity.getNome(), entity.getEmail());
    }
}
