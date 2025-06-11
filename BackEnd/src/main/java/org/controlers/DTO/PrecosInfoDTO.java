package org.controlers.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PrecosInfoDTO {
    public BigDecimal preco;
    public String mercado;
    public LocalDate ultimaAtualizacao;

    public PrecosInfoDTO(BigDecimal preco, String mercado, LocalDate ultimaAtualizacao) {
        this.preco = preco;
        this.mercado = mercado;
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
    
}
