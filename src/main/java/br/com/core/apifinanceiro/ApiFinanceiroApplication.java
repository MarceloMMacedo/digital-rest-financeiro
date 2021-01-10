package br.com.core.apifinanceiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 

@EntityScan({ "br.com.core.dbcore.domain" })
@EnableJpaRepositories({ "br.com.core.apifinanceiro" })
@SpringBootApplication
public class ApiFinanceiroApplication implements CommandLineRunner {
	@Autowired
	IntTable intTable;

	public static void main(String[] args) {
		SpringApplication.run(ApiFinanceiroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		intTable.intTable();
	}
}
