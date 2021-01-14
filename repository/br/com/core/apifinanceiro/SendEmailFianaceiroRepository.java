package br.com.core.apifinanceiro;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.core.dbcore.domain.agenda.SendEmailFianaceiro;

public interface SendEmailFianaceiroRepository extends JpaRepository<SendEmailFianaceiro, Long> {

	SendEmailFianaceiro findByStatusAndDatalancamentoAndTipoemailreport(String status, Date datalancamento,
			String ipoemailreport);

}
