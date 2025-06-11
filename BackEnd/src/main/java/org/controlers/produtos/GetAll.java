package org.controlers.produtos;

import java.util.List;
import java.util.stream.Collectors;

import org.controlers.DTO.GetAllProdutosDTO;
import org.controlers.DTO.PrecosInfoDTO;
import org.entity.Precos;
import org.entity.Produtos;
import org.repository.ProdutosRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/produtos")    
public class GetAll {
    @Inject
    ProdutosRepository produtosRepository;
    
    @GET
    @Path("/getAll")
    public Response getAll() {
        
        List<Produtos> produtos = produtosRepository.listAll();
        
        List<GetAllProdutosDTO> dto = produtos.stream()
        .map(p -> {
            List<Precos> precos = p.getPrecos();
            
            List<PrecosInfoDTO> precosInfo = precos.stream()
            .map(pr -> new PrecosInfoDTO(pr.getPreco(), pr.getMercados().getNome(), pr.getUltimaAtualizacao()))
            .collect(Collectors.toList());
            
            return new GetAllProdutosDTO(p.getId(), p.getNome(), p.getMedidas().getMedida(), p.getCategoria().getCategoria(), precosInfo);
        })
        .collect(Collectors.toList());

        return Response.ok(dto).build();
    }

    
}
