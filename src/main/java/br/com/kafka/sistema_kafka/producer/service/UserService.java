package br.com.kafka.sistema_kafka.producer.service;

import br.com.kafka.sistema_kafka.producer.dto.request.UserDTO;
import br.com.kafka.sistema_kafka.producer.dto.response.UserResponseDTO;
import br.com.kafka.sistema_kafka.producer.model.UserEntity;
import br.com.kafka.sistema_kafka.producer.repository.UserRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher eventPublisher;

    public UserService(UserRepository userRepository, ApplicationEventPublisher eventPublisher) {
        this.userRepository = userRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public UserResponseDTO  cadastrarUserEEnviarNotificacao(UserDTO userDTO){
        UserEntity entity = userDTO.toEntity();
        UserEntity usuarioSalvo = userRepository.save(entity);
        eventPublisher.publishEvent(usuarioSalvo);
        return UserResponseDTO.fromEntity(usuarioSalvo);
    }
}
