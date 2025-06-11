package org.controlers.precos;

import java.time.LocalDate;

import org.controlers.DTO.DefinirPrecoDTO;
import org.entity.Mercados;
import org.entity.Precos;
import org.entity.Produtos;
import org.repository.MercadoRepository;
import org.repository.PrecosRepository;
import org.repository.ProdutosRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/preco")
public class DefinirPreco {
    @Inject
    PrecosRepository precoRepository;
    @Inject
    MercadoRepository mercadoRepository;
    @Inject
    ProdutosRepository produtosRepository;
    
    @Path("/definir")
    @POST
    @Transactional
    public Response definirPreco(DefinirPrecoDTO dto) {

        Mercados mercado = mercadoRepository.findById(dto.mercadoId);
        if(mercado == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        Produtos produto = produtosRepository.findById(dto.produtoId);
        if(produto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        Precos precoExistente = precoRepository.findByMercadosAndProdutos(mercado, produto);
        if(precoExistente != null) {
            precoExistente.setPreco(dto.preco);
            precoExistente.setUltimaAtualizacao(LocalDate.now());
            precoExistente.persist();
            return Response.ok("Preço atualizado com sucesso").build();
        }
        
        Precos preco = new Precos(dto.preco, mercado, produto);
        precoRepository.persist(preco);
        return Response.ok("Preço aplicado com sucesso").build();
    }


}
