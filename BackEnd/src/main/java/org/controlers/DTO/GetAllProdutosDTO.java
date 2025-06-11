package org.controlers.DTO;

import java.util.List;

public class GetAllProdutosDTO {
    public Long id;
    public String produtoname;
    public String medida;
    public String categoria;
    public List<PrecosInfoDTO> precos;

    public GetAllProdutosDTO(Long id, String produtoname, String medida, String categoria, List<PrecosInfoDTO> precos) {
        this.id = id;
        this.produtoname = produtoname;
        this.medida = medida;
        this.categoria = categoria;
        this.precos = precos;
    }


    
}
