package org.controlers.produtos;

import java.util.List;
import java.util.stream.Collectors;

import org.controlers.DTO.GetProdutoByMercadoDTO;
import org.entity.Mercados;
import org.entity.Precos;
import org.repository.MercadoRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/produto")
public class GetByMercado {
    @Inject
    MercadoRepository mercadoRepository;

    @Path("/getByMercado/{mercadoId}")
    @GET
    public Response getByMercado(@PathParam("mercadoId") Long mercadoId) {

        Mercados mercado = mercadoRepository.findById(mercadoId);
        if (mercado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        List<Precos> precos = mercado.getPrecos();

        List<GetProdutoByMercadoDTO> dto = precos.stream()
        .map(p -> new GetProdutoByMercadoDTO(p.getProdutos().getId(), p.getProdutos().getNome(), p.getPreco()))
        .collect(Collectors.toList());


        
        return Response.ok(dto).build();
    }
    
}
