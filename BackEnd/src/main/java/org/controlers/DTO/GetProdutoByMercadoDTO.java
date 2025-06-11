package org.controlers.DTO;

import java.math.BigDecimal;

public class GetProdutoByMercadoDTO {
    public Long produtoId;
    public String produto;
    public BigDecimal preco;

    public GetProdutoByMercadoDTO(){}
    public GetProdutoByMercadoDTO(Long produtoId, String produto, BigDecimal preco) {
        this.produtoId = produtoId;
        this.produto = produto;
        this.preco = preco;
    }
}
