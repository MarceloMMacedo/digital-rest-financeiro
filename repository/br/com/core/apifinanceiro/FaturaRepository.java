package br.com.core.apifinanceiro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.core.dbcore.domain.financeiro.movimento.Fatura;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Integer> {

	@Transactional(readOnly = true)
	Fatura findByStatusAndNaturezamovimentoAndHistoricoCentrocustoId(String status, String naturezamovimento,
			int centrocustoId);

	@Transactional(readOnly = true)
	List<Fatura> findAllByStatusAndNaturezamovimentoAndHistoricoAgregadofinanceirosCentrocustoId(String status,
			String naturezamovimento, int centrocustoId);
	
	@Transactional(readOnly = true)
	List<Fatura> findAllByStatusAndTipomovimento( String status ,String tipomovimento);

	@Query("SELECT  SUM( f.valor+ f.jurus+ f.multa- f.desconto) FROM Fatura f WHERE EXTRACT(YEAR FROM f.dataVencimento) <?1 AND"
			+ "  f.status =?2   AND f.historico.id=?3 And f.tipomovimento=?4  group by f.historico.id")
	double totalAnterior(Integer exercicio, String status, Integer id,String tipomovimento);

	@Query("SELECT  SUM( f.valor+ f.jurus+ f.multa- f.desconto) FROM Fatura f WHERE EXTRACT(YEAR FROM f.dataVencimento) =?1 AND"
			+ "  f.status =?2   AND f.historico.id=?3 And f.tipomovimento=?4  group by f.historico.id")
	double totalexercicioAtual(Integer exercicio, String status, Integer id,String tipomovimento);

	@Query("SELECT  SUM( f.valor+ f.jurus+ f.multa- f.desconto) FROM Fatura f WHERE EXTRACT(YEAR FROM f.dataVencimento) >?1 AND"
			+ "  f.status =?2   AND f.historico.id=?3  And f.tipomovimento=?4  group by f.historico.id")
	double totalexercicioPosterior(Integer exercicio, String status, Integer id,String tipomovimento);

	@Query("SELECT  SUM( f.valor+ f.jurus+ f.multa- f.desconto) FROM Fatura f WHERE EXTRACT(YEAR FROM f.dataVencimento) =?1 AND"
			+ " EXTRACT(MONTH FROM f.dataVencimento) =?2 AND  f.status =?3 And f.tipomovimento=?4  ")
	double totalmesByExercicio(Integer exercicio, Integer mes, String status,String tipomovimento);

	@Query("SELECT  SUM( f.valor+ f.jurus+ f.multa- f.desconto) FROM Fatura f WHERE EXTRACT(YEAR FROM f.dataVencimento) =?1 AND"
			+ " EXTRACT(MONTH FROM f.dataVencimento) =?2 AND  f.status =?3   AND f.historico.id=?4 "
			+ "And f.tipomovimento=?5  group by f.historico.id ")
	double totalmes(Integer exercicio, Integer mes, String status, Integer id,String tipomovimento);

	@Query("SELECT EXTRACT(YEAR FROM f.dataVencimento ) FROM Fatura f WHERE  f.tipomovimento=?1 GROUP BY  EXTRACT(YEAR FROM f.dataVencimento)")
	List<Integer> findbyano(String tipomovimento);

	@Query("SELECT  SUM( f.valor+ f.jurus+ f.multa- f.desconto) FROM Fatura f WHERE EXTRACT(YEAR FROM f.dataVencimento) =?1 AND"
			+ "   f.status =?2 And f.tipomovimento=?3")
	double totalAnoByExercicio(Integer exercicio, String status, String tipoMovimento);

	// Movimento financeiro
	@Query("SELECT  SUM( f.valor+ f.jurus+ f.multa- f.desconto) FROM Fatura f WHERE EXTRACT(YEAR FROM f.dataVencimento) <?1 AND"
			+ "  f.status =?2   AND f.movimentoFinanceiro.id=?3 group by f.movimentoFinanceiro.id")
	double totalmovimentoFinanceiroAnterior(Integer exercicio, String status, Integer id);

	@Query("SELECT  SUM( f.valor+ f.jurus+ f.multa- f.desconto) FROM Fatura f WHERE EXTRACT(YEAR FROM f.dataVencimento) =?1 AND"
			+ "  f.status =?2   AND f.movimentoFinanceiro.id=?3  group by f.movimentoFinanceiro.id")
	double totalemovimentoFinanceiroxercicioAtual(Integer exercicio, String status, Integer id);

	@Query("SELECT  SUM( f.valor+ f.jurus+ f.multa- f.desconto) FROM Fatura f WHERE EXTRACT(YEAR FROM f.dataVencimento) >?1 AND"
			+ "  f.status =?2   AND f.movimentoFinanceiro.id=?3  group by f.movimentoFinanceiro.id")
	double totalmovimentoFinanceiroexercicioPosterior(Integer exercicio, String status, Integer id);

	@Query("SELECT  SUM( f.valor+ f.jurus+ f.multa- f.desconto) FROM Fatura f WHERE EXTRACT(YEAR FROM f.dataVencimento) =?1 AND"
			+ " EXTRACT(MONTH FROM f.dataVencimento) =?2 AND  f.status =?3  group by f.movimentoFinanceiro.id")
	double totalmovimentoFinanceiromesByExercicio(Integer exercicio, Integer mes, String status);

	@Query("SELECT  SUM( f.valor+ f.jurus+ f.multa- f.desconto) FROM Fatura f WHERE EXTRACT(YEAR FROM f.dataVencimento) =?1 AND"
			+ " EXTRACT(MONTH FROM f.dataVencimento) =?2 AND  f.status =?3   AND f.movimentoFinanceiro.id=?4  And f.tipomovimento=?5"
			+ "  group by f.movimentoFinanceiro.id ")
	double totalmovimentoFinanceiromes(Integer exercicio, Integer mes, String status, Integer id, String tipoMovimento);

}
