package br.com.kafka.sistema_kafka.consumer;

import br.com.kafka.sistema_kafka.producer.model.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class NotificacaoConsumer {

    @Bean
    public Consumer<UserEntity> cosumirNotificacao() {
        return usuario -> {
            System.out.println("\n=========================================");
            System.out.println("NOTIFICAÇÃO RECEBIDA VIA KAFKA!");
            System.out.println("ID do Usuário Criado no Banco: " + usuario.getId());
            System.out.println("Enviando e-mail de boas-vindas para: " + usuario.getNome());
            System.out.println("Endereço: " + usuario.getEmail());
            System.out.println("=========================================\n");
        };
    }
}
