package br.gov.sp.fatec.spc.modalidade.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "modalidade")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
public class Modalidade implements Serializable {
    @Id
    @Column(name = "cod_modalidade", length = 3)
    private String id;

    @Column(name = "des_modalidade")
    private String descricao;
}
