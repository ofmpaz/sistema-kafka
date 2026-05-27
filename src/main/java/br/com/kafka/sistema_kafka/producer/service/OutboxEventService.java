package br.com.kafka.sistema_kafka.producer.service;

import br.com.kafka.sistema_kafka.producer.model.OutboxEventEntity;
import br.com.kafka.sistema_kafka.producer.repository.OutboxEventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class OutboxEventService {

    private final OutboxEventRepository eventeRepository;
    private final StreamBridge streamBridge;

    @Scheduled(fixedDelay = 5000)
    public void processarEventosPendentes() {

        List<OutboxEventEntity> pendentes = eventeRepository.findByStatus("PENDENTE");

        for (OutboxEventEntity event : pendentes) {
            try {
                streamBridge.send("notificacao-out-0", event.getPayload());
                event.setStatus("ENVIADO");
                log.info("Evento enviado com sucesso: id={}", event.getId());

            } catch (Exception e) {
                event.setStatus("ERRO");
                log.error("Falha ao enviar evento: id={}", event.getId(), e);
            }

            eventeRepository.save(event);
        }
    }
}
