package org.controlers.DTO;

public class GetAllProdutosNamesDTO {
    public Long id;
    public String name;
    public String medida;

    public GetAllProdutosNamesDTO(Long id, String name, String medida) {
        this.id = id;
        this.name = name;
        this.medida = medida;
    }
    
    
}
