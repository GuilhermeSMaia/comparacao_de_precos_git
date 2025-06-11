package org.controlers.produtos;

import java.util.List;
import java.util.stream.Collectors;

import org.controlers.DTO.GetProdutoByIdDTO;
import org.controlers.DTO.PrecosInfoDTO;
import org.entity.Precos;
import org.entity.Produtos;
import org.repository.ProdutosRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

public class GetById {
    
    @Inject
    ProdutosRepository produtosRepository;
    
    @GET
    @Path("/produtos/{id}")
    public Response getById(@PathParam("id") Long id) {

        Produtos produto = produtosRepository.findById(id);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        List<Precos> precos = produto.getPrecos();
        List<PrecosInfoDTO> precosInfo = precos.stream()
        .map(p -> new PrecosInfoDTO(p.getPreco(), p.getMercados().getNome(), p.getUltimaAtualizacao()))
        .collect(Collectors.toList());

        GetProdutoByIdDTO produtoDTO = new GetProdutoByIdDTO(produto.getId(), produto.getNome(), precosInfo);

        return Response.ok(produtoDTO).build();
    }
    
}
