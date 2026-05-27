package br.com.kafka.sistema_kafka.producer.dto.request;

import br.com.kafka.sistema_kafka.producer.model.UserEntity;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank
        String nome,
        @NotBlank
        String email) {

    public UserEntity toEntity() {
        UserEntity entity = new UserEntity();
        entity.setNome(this.nome());
        entity.setEmail(this.email());
        return entity;
    }
}
