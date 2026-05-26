package br.com.kafka.sistema_kafka.producer.service;

import br.com.kafka.sistema_kafka.producer.model.UserEntity;
import br.com.kafka.sistema_kafka.producer.dto.UserDTO;
import br.com.kafka.sistema_kafka.producer.repository.UserRepository;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final StreamBridge streamBridge;

    public UserService(UserRepository userRepository, StreamBridge streamBridge) {
        this.userRepository = userRepository;
        this.streamBridge = streamBridge;
    }

    @Transactional
    public void cadastrarUserEEnviarNotificação(UserDTO userDTO){
        UserEntity entity = new UserEntity();
        entity.setNome(userDTO.nome());
        entity.setEmail(userDTO.email());
        UserEntity usuarioSalvo = userRepository.saveAndFlush(entity);
        streamBridge.send("notificacao-out", usuarioSalvo);
    }
}
