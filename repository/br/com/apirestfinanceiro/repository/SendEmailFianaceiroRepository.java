package br.com.apirestfinanceiro.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apifinanceiro.domain.agenda.SendEmailFianaceiro;

public interface SendEmailFianaceiroRepository extends JpaRepository<SendEmailFianaceiro, Long> {

	SendEmailFianaceiro findByStatusAndDatalancamentoAndTipoemailreport(String status, Date datalancamento,
			String ipoemailreport);

}
