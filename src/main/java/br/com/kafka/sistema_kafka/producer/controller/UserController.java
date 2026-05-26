package br.com.kafka.sistema_kafka.producer.controller;

import br.com.kafka.sistema_kafka.producer.dto.UserDTO;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/v1")
public class UserController {

    private final StreamBridge streamBridge;

    public UserController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody UserDTO usuarioDTO) {
        streamBridge.send("notificacao-out", usuarioDTO);
        return ResponseEntity.ok("Cadastro recebido. Evento disparado para o kafka");
    }
}
