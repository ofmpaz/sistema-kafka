package br.com.kafka.sistema_kafka.producer.controller;

import br.com.kafka.sistema_kafka.producer.dto.request.UserDTO;
import br.com.kafka.sistema_kafka.producer.dto.response.UserResponseDTO;
import br.com.kafka.sistema_kafka.producer.service.UserService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/v1")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/usuario")
    public ResponseEntity<UserResponseDTO> cadastrarUsuario(@RequestBody UserDTO usuarioDTO) {
        UserResponseDTO response = userService.cadastrarUserEEnviarNotificacao(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
