package org.controlers.DTO;

import java.util.List;

public class GetProdutoByIdDTO {
    public Long id;
    public String produtoname;
    public List<PrecosInfoDTO> precos;
    public GetProdutoByIdDTO(Long id, String produtoname, List<PrecosInfoDTO> precos) {
        this.id = id;
        this.produtoname = produtoname;
        this.precos = precos;
    }
    
}
