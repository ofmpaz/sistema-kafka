package br.com.kafka.sistema_kafka.listener;

import br.com.kafka.sistema_kafka.producer.dto.response.UserResponseDTO;
import br.com.kafka.sistema_kafka.producer.model.UserEntity;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class UserNotificationListener {

    private final StreamBridge streamBridge;

    public UserNotificationListener(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void usuarioSalvo(UserEntity usuarioSalvado) {
        UserResponseDTO playload = UserResponseDTO.fromEntity(usuarioSalvado);
        streamBridge.send("notificacao-out",playload);
    }
}
