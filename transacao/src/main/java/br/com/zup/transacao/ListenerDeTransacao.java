package br.com.zup.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.transacao.entity.Transacao;
import br.com.zup.transacao.repository.TransacaoRepository;

@Component
public class ListenerDeTransacao {

	@Autowired
	private TransacaoRepository manager;
	
	@KafkaListener(topics = "${spring.kafka.topic.transactions}", groupId = "${spring.kafka.consumer.group-id}")
	public void ouvir(EventoDeTransacao evento) {
		System.out.println(evento);
		Transacao transacao = evento.converter();
		manager.save(transacao);
	}
}
