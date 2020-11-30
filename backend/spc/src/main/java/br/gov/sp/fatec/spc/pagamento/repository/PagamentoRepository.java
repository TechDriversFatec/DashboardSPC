package br.gov.sp.fatec.spc.pagamento.repository;

import br.gov.sp.fatec.spc.pagamento.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, String>{


    @Query("SELECT p FROM Pagamento p WHERE p.dataPagParcela IS NULL AND p.datVencimento >= current_date()")
    List<Pagamento> findAllByPendentes();

    @Query("SELECT p FROM Pagamento p WHERE p.datVencimento < current_date() and p.dataPagParcela IS NULL")
    List<Pagamento> findAllByAtrasado();

    @Query("SELECT p FROM Pagamento p WHERE p.dataPagParcela IS NOT NULL")
    List<Pagamento> findAllByPago();

    @Query("SELECT p FROM Pagamento p WHERE p.dataPagParcela > p.datVencimento")
    List<Pagamento> findAllByPagosAtrasados();

    @Query("SELECT p FROM Pagamento p WHERE p.dataPagParcela <= p.datVencimento")
    List<Pagamento> findAllByPagosEmDia();

    @Query("SELECT p FROM Pagamento p WHERE p.pessoaFisica like :pessoaFisica")
    List<Pagamento> findByTodosPagsPessoa(@Param("pessoaFisica") String pessoaFisica);

    @Query("SELECT p FROM Pagamento p WHERE p.pessoaFisica = :pessoaFisica AND p.dataPagParcela <= p.datVencimento")
    List<Pagamento> findByPagsPagosPessoa(@Param("pessoaFisica") String pessoaFisica);

    @Query("SELECT p FROM Pagamento p WHERE p.pessoaFisica = :pessoaFisica AND p.dataPagParcela > p.datVencimento")
    List<Pagamento> findByPagsAtrasadoPessoa(@Param("pessoaFisica") String pessoaFisica);

    @Query("SELECT p FROM Pagamento p WHERE p.pessoaFisica = :pessoaFisica AND p.datVencimento < current_date() AND p.dataPagParcela IS NULL")
    List<Pagamento> findByPagsPagoAtrasadoPessoa(@Param("pessoaFisica") String pessoaFisica);

}
