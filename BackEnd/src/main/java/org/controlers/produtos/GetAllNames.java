package org.controlers.produtos;

import java.util.List;
import java.util.stream.Collectors;

import org.controlers.DTO.GetAllProdutosNamesDTO;
import org.entity.Produtos;
import org.repository.ProdutosRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/produtos")
public class GetAllNames {

    @Inject
    ProdutosRepository produtosRepository;

    @GET
    @Path("/getAllNames")
    public Response getAllProdutos( ) {
        List<Produtos> produtos = produtosRepository.listAll();

     
        List<GetAllProdutosNamesDTO> nomes = produtos.stream()
            .map(p -> new GetAllProdutosNamesDTO(p.getId(), p.getNome(), p.getMedidas().getMedida()))
            .collect(Collectors.toList());

        return Response.ok(nomes).build();
    }
       
    
}
